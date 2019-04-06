export const namespaced = true

export const state = {
  loading: 0
}

export const mutations = {
  START_LOADING (state) {
    state.loading++
  },
  FINISH_LOADING (state) {
    state.loading--
  }
}

export const actions = {
  startLoading ({ commit }) {
    commit('START_LOADING')
  },
  finishLoading ({ commit }) {
    commit('FINISH_LOADING')
  }
}

export const getters = {
  isLoading: state => {
    return state.loading !== 0
  }
}
