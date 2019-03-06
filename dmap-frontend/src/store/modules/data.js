export const namespaced = true

export const state = {
  dataEstimations: [],
  furtherDataDescription: ''
}

export const mutations = {
  ADD_DATA_ESTIMATION (state, estimation) {
    state.dataEstimations.push(Object.assign({}, estimation))
  },
  REMOVE_DATA_ESTIMATION (state, estimation) {
    // TODO
  },
  SET_FURTHER_DATA_DESCRIPTION (state, description) {
    state.furtherDataDescription = description
  }
}

export const actions = {
  addDataEstimation ({ commit }, estimation) {
    commit('ADD_DATA_ESTIMATION', estimation)
  },
  removeDataEstimation ({ commit }, estimation) {
    commit('REMOVE_DATA_ESTIMATION', estimation)
  },
  setFurtherDataDescription ({ commit }, description) {
    commit('SET_FURTHER_DATA_DESCRIPTION', description)
  }
}

export const getters = {
  getDataEstimations: state => {
    return state.dataEstimations
  },
  getDataEstimationsCount: state => {
    return state.dataEstimations.length
  },
  getFurtherDataDescription: state => {
    return state.furtherDataDescription
  }
}
