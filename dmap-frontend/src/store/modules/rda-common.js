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
        description: 'This DMP is for our new project.',
        language: 'en',
        created: new Date().toISOString(),
        modified: new Date().toISOString()
      }
    })

    let dataManagementStaff = rootGetters['people/getDataManagementStaff']
    let contact = dataManagementStaff.find(p => {
      return p.dataManagementRoles.includes('Main contact person for DMP')
    })

    if (contact) {
      dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
        contact: {
          name: contact.personDetails.first_name + ' ' + contact.personDetails.last_name,
          mbox: contact.personDetails.main_email,
          contact_id: TISS_PERSON_URL + contact.personDetails.tiss_id,
          contact_id_type: 'HTTP-TISS'
        }
      })
    }

    let dmStaff = dataManagementStaff.map(p => {
      let person = {}
      person.name = p.personDetails.first_name + ' ' + p.personDetails.last_name
      person.mbox = p.personDetails.main_email
      person.staff_id = TISS_PERSON_URL + p.personDetails.tiss_id
      person.staff_id_type = 'HTTP-TISS'
      person.contributer_type = p.dataManagementRoles

      return person
    })

    if (dmStaff && dmStaff.length > 0) {
      dmpContainer.dmp = Object.assign(dmpContainer.dmp, {
        dm_staff: dmStaff
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
      project.project_id = TISS_PDB_URL + p.projectId
      project.project_id_type = 'HTTP-PDB'
      project.start = p.begin
      project.end = p.end

      let projectDetails = rootGetters['project/getProjectDetailsById'](p.projectId)
      if (projectDetails.abstract && projectDetails.abstract.en) {
        project.description = projectDetails.abstract.en
      }

      if (projectDetails.financiers) {
        let fundings = projectDetails.financiers.map(f => {
          let funding = {}
          funding.funder_name = f.funderName.en
          funding.funder_id = ''
          funding.funder_id_type = ''
          funding.grant_id = ''
          funding.grant_id_type = ''

          if (f.program) {
            let index = f.program.findIndex(fp => fp.infoTypeCode === 'AUSSCHREIBUNGS_KENNUNG')
            if (index > -1) {
              funding.grant_id = f.program[index].infoValue.en
              funding.grant_id_type = f.program[index].infoTag.en
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
        host.host_id = RE3DATA_URL + h.id
        host.host_id_type = 'HTTP-RE3DATA'
        host.description = hostDetails.description
        host.supports_versioning = hostDetails.versioning ? hostDetails.versioning : booleanToString(undefined)
        host.storage_type = hostDetails.repositoryTypes
        if (hostDetails.certificates) {
          host.certified_with = hostDetails.certificates
        }
        host.pid_system = hostDetails.pidSystems

        return host
      })

      let distributions = []
      let plannedDistribution = rootGetters['license/getDistributions'].find(dist => dist.datasetName === d.datasetName)
      let distribution = {}
      distribution.title = 'Planned distribution'
      distribution.format = []
      d.dataEstimations.forEach(est => {
        distribution.format.push(est.estimatedType.description)
      })
      if (d.totalSizeMin === d.totalSizeMax) {
        distribution.byte_size = d.totalSizeMin
      } else {
        distribution.byte_size_range = {
          from: d.totalSizeMin,
          to: d.totalSizeMax
        }
      }

      distribution.data_access = plannedDistribution.dataAccess ? 'open' : 'closed'

      if (plannedDistribution.dataAccess) {
        distribution.license = []
        distribution.license.push({
          license_name: plannedDistribution.license.name,
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
          distributionPerHost.available_till =
            rootGetters['repository/getSelectedRepositoryById'](h.host_id.substring(RE3DATA_URL.length)).availableUntil
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
