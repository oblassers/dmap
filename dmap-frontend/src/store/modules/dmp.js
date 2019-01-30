import BackendService from '@/services/BackendService.js'

export const namespaced = true

export const state = {
  dmps: []
}

export const mutations = {
  SET_DMPS (state, dmps) {
    state.dmps = dmps
  }
}

export const actions = {
  fetchDmps ({ commit }) {
    return BackendService.getDmps()
      .then(response => {
        commit('SET_DMPS', response.data)
      })
      .catch(error => {
        console.log(error.message)
      })
  }
}

export const getters = {
}
