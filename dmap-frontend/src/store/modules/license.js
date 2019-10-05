export const namespaced = true

export const state = {
  distributions: []
}

export const mutations = {
  ADD_DISTRIBUTION (state, datasetName) {
    state.distributions.findIndex(d => d.datasetName === datasetName) === -1
      ? state.distributions.push(Object.assign({}, {
        datasetName: datasetName,
        dataAccess: false,
        license: undefined,
        licenseActiveDate: ''
      })) : console.log('Distribution for ' + datasetName + ' already contained')
  },
  REMOVE_DISTRIBUTION (state, datasetName) {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    index > -1 ? state.distributions.splice(index, 1)
      : console.log('Distribution for ' + datasetName + ' not contained')
  },
  UPDATE_DISTRIBUTIONS (state, datasetNames) {
    datasetNames.forEach(name => {
      if (state.distributions.findIndex(distribution => distribution.datasetName === name) === -1) {
        state.distributions.push(Object.assign({}, {
          datasetName: name,
          dataAccess: false,
          license: undefined,
          licenseActiveDate: ''
        }))
      }
    })
    state.distributions = state.distributions.filter(distribution =>
      datasetNames.findIndex(name => name === distribution.datasetName) > -1)
  },
  SET_DATA_ACCESS (state, { datasetName, access }) {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    index > -1 ? state.distributions[index].dataAccess = access
      : console.log('Distribution for ' + datasetName + ' not contained')
  },
  SET_LICENSE (state, { datasetName, license }) {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    index > -1 ? state.distributions[index].license = license
      : console.log('Distribution for ' + datasetName + ' not contained')
  },
  SET_LICENSE_ACTIVE_DATE (state, { datasetName, activeDate }) {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    index > -1 ? state.distributions[index].licenseActiveDate = activeDate
      : console.log('Distribution for ' + datasetName + ' not contained')
  },
  SET_OTHER_LICENSE_DESCRIPTION (state, { datasetName, licenseDescription }) {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    if (index > -1) {
      if (state.distributions[index].license && state.distributions[index].license.name === 'Other') {
        state.distributions[index].license.description = licenseDescription
      } else {
        console.log('License is not set to Other')
      }
    } else {
      console.log('Distribution for ' + datasetName + ' not contained')
    }
  }
}

export const actions = {
  addDistribution ({ commit }, datasetName) {
    commit('ADD_DISTRIBUTION', datasetName)
  },
  removeDistribution ({ commit }, datasetName) {
    commit('REMOVE_DISTRIBUTION', datasetName)
  },
  updateDistributions ({ commit }, datasetNames) {
    commit('UPDATE_DISTRIBUTIONS', datasetNames)
  },
  setDataAccess ({ commit }, payload) {
    commit('SET_DATA_ACCESS', payload)
  },
  setLicense ({ commit }, payload) {
    commit('SET_LICENSE', payload)
  },
  setLicenseActiveDate ({ commit }, payload) {
    commit('SET_LICENSE_ACTIVE_DATE', payload)
  },
  setOtherLicenseDescription ({ commit }, payload) {
    commit('SET_OTHER_LICENSE_DESCRIPTION', payload)
  }
}

export const getters = {
  getDistributions: state => {
    return state.distributions
  },
  getDistribution: state => datasetName => {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    if (index > -1) {
      return state.distributions[index]
    }
    return undefined
  },
  getDataAccess: state => datasetName => {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    if (index > -1) {
      return state.distributions[index].dataAccess
    }
    return undefined
  },
  getLicense: state => datasetName => {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    if (index > -1) {
      return state.distributions[index].license
    }
    return undefined
  },
  getLicenseActiveDate: state => datasetName => {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    if (index > -1) {
      return state.distributions[index].licenseActiveDate
    }
    return ''
  },
  getOtherLicenseDescription: state => datasetName => {
    let index = state.distributions.findIndex(d => d.datasetName === datasetName)
    if (index > -1) {
      if (state.distributions[index].license && state.distributions[index].license.name === 'Other') {
        return state.distributions[index].license.description
      }
    }
    return ''
  }
}
