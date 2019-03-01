export const namespaced = true

export const state = {
  furtherDataDescription: ''
}

export const mutations = {
  SET_FURTHER_DATA_DESCRIPTION (state, description) {
    state.furtherDataDescription = description
  }
}

export const actions = {
  setFurtherDataDescription ({ commit }, description) {
    commit('SET_FURTHER_DATA_DESCRIPTION', description)
  }
}

export const getters = {
  getFurtherDataDescription: state => {
    return state.furtherDataDescription
  }
}
