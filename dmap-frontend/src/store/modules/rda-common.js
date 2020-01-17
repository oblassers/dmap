/**
 * Construct a DMP data model according to the RDA DMP Common Standard
 * https://github.com/RDA-DMP-Common/RDA-DMP-Common-Standard
 */

function booleanToString (b) {
  if (b === undefined) {
    return 'unknown'
  } else if (b) {
    return 'yes'
  } else {
    return 'no'
  }
}

export const namespaced = true

const TISS_PERSON_URL = 'https://www.tiss.tuwien.ac.at/person/'
const TISS_PDB_URL = 'https://tiss.tuwien.ac.at/api/pdb/rest/project/v3/'
const RE3DATA_URL = 'https://www.re3data.org/repository/'

export const actions = {
  constructRdaDmpCommonStandard ({ state, commit, rootState, rootGetters }) {
    let dmpContainer = Object.assign({}, {
      dmp: {
        title: 'DMP for our new project',
        dmp_id: {
          identifier: '89bf3739-a352-4b70-9ef3-3322f2ce6b51',
          type: 'other'
        },
        description: 'This DMP is for our new project.',
        language: 'eng',
        created: new Date().toISOString(),
        modified: new Date().toISOString()
      }
    })

    let dataManagementStaff = rootGetters['people/getDataManagementStaff']
    let contact = dataManagementStaff.find(p => {
      return p.dataManagementRoles.includes('ContactPerson')
    })

    if (contact) {
      dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
        contact: {
          name: contact.personDetails.first_name + ' ' + contact.personDetails.last_name,
          mbox: contact.personDetails.main_email,
          contact_id: {
            identifier: TISS_PERSON_URL + contact.personDetails.tiss_id,
            type: 'other'
          }
        }
      })
    }

    let dmStaff = dataManagementStaff.map(p => {
      let person = {}
      person.name = p.personDetails.first_name + ' ' + p.personDetails.last_name
      person.mbox = p.personDetails.main_email
      person.contributor_id = {
        identifier: TISS_PERSON_URL + p.personDetails.tiss_id,
        type: 'other'
      }
      person.role = p.dataManagementRoles

      return person
    })

    if (dmStaff && dmStaff.length > 0) {
      dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
        contributor: dmStaff
      })
    }

    dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
      ethical_issues_exist: booleanToString(rootGetters['legal/hasEthicalIssues'])
    })

    let ethicalIssuesReport = rootGetters['legal/getLinkToEthicsReport']
    if (ethicalIssuesReport) {
      dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
        ethical_issues_report: ethicalIssuesReport
      })
    }

    let ethicalIssuesDescription = rootGetters['legal/getEthicalComplianceStatement']
    if (ethicalIssuesDescription) {
      dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
        ethical_issues_description: ethicalIssuesDescription
      })
    }

    let projects = rootGetters['project/getSelectedProjects'].map(p => {
      let project = {}
      project.title = p.titleEn
      project.project_id = {
        identifier: TISS_PDB_URL + p.projectId,
        type: 'tiss-pdb'
      }
      project.start = p.begin
      project.end = p.end

      let projectDetails = rootGetters['project/getProjectDetailsById'](p.projectId)
      if (projectDetails.abstract && projectDetails.abstract.en) {
        project.description = projectDetails.abstract.en
      }

      if (projectDetails.financiers) {
        let fundings = projectDetails.financiers.map(f => {
          let funding = {}

          funding.funder_id = {
            identifier: f.funderName.en,
            type: 'other'
          }
          funding.grant_id = {
            identifier: '',
            type: ''
          }

          if (f.program) {
            let index = f.program.findIndex(fp => fp.infoTypeCode === 'AUSSCHREIBUNGS_KENNUNG')
            if (index > -1) {
              funding.grant_id.identifier = f.program[index].infoValue.en
              funding.grant_id.type = 'other'
            }
          }

          return funding
        })
        project.funding = fundings
      }

      return project
    })
    if (projects && projects.length > 0) {
      dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
        project: projects
      })
    }

    let datasets = rootGetters['data/getDatasets'].map(d => {
      let dataset = {}
      dataset.title = d.datasetName
      dataset.dataset_id = {
        identifier: '',
        type: 'other'
      }
      dataset.personal_data = booleanToString(
        rootGetters['legal/containsPersonalInformation'] &&
        rootGetters['legal/getDatasetsWithPersonalInformation'].includes(d.datasetName))
      dataset.sensitive_data = booleanToString(
        rootGetters['legal/isDataSensitive'] &&
        rootGetters['legal/getSensitiveDatasets'].includes(d.datasetName))

      if (d.dataEstimations) {
        let types = d.dataEstimations.map(est => {
          let type = {}
          type.name = est.estimatedType.label
          type.description = est.comment

          return type
        })
        dataset.type = types
      }

      let hosts = rootGetters['repository/getSelectedRepositoriesByDatasetName'](d.datasetName).map(h => {
        let host = {}
        let hostDetails = rootGetters['repository/getRepositoryDetailsById'](h.id)
        host.title = h.name
        host.host_id = {
          identifier: RE3DATA_URL + h.id,
          type: 're3data'
        }
        host.url = hostDetails.repositoryUrl
        host.description = hostDetails.description
        host.support_versioning = hostDetails.versioning ? hostDetails.versioning : booleanToString(undefined)
        host.storage_type = 'repository'
        if (hostDetails.certificates) {
          host.certified_with = hostDetails.certificates
        }
        host.pid_system = hostDetails.pidSystems.map(p => p.toLowerCase())

        return host
      })

      let distributions = []
      let plannedDistribution = rootGetters['license/getDistributions'].find(dist => dist.datasetName === d.datasetName)
      let distribution = {}
      distribution.title = 'Planned distribution'
      distribution.format = []
      d.dataEstimations.forEach(est => {
        if (est.estimatedType.mimeType) {
          distribution.format.push(est.estimatedType.mimeType)
        }
      })
      // to be compliant with the standard only use upper bound
      distribution.byte_size = d.totalSizeMax

      distribution.data_access = plannedDistribution.dataAccess ? 'open' : 'closed'

      if (plannedDistribution.dataAccess) {
        distribution.license = []
        distribution.license.push({
          name: plannedDistribution.license.name,
          license_ref: plannedDistribution.license.url,
          start_date: plannedDistribution.licenseActiveDate
        })
      }

      if (hosts.length === 0) {
        distributions.push(distribution)
      } else {
        hosts.forEach(h => {
          let distributionPerHost = Object.assign({}, distribution)
          distributionPerHost.host = h
          distributionPerHost.available_until =
            rootGetters['repository/getSelectedRepositoryById'](
              h.host_id.identifier.substring(RE3DATA_URL.length)).availableUntil
          distributions.push(distributionPerHost)
        })
      }

      if (distributions.length > 0) {
        dataset.distribution = distributions
      }

      return dataset
    })

    if (datasets && datasets.length > 0) {
      dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
        dataset: datasets
      })
    }

    return dmpContainer
  }
}
