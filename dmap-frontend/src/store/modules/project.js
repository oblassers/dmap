import BackendService from '@/services/BackendService.js'

export const namespaced = true

export const state = {
  projects: [],
  selectedProjects: []
}

export const mutations = {
  SET_PROJECTS (state, projects) {
    state.projects = projects
  }
}

export const actions = {
  fetchProjectSuggestions ({ commit, rootState }) {
    return BackendService.getProjectSuggestions(rootState.user)
      .then(response => {
        commit('SET_PROJECTS', response.data)
      })
      .catch(error => {
        console.log('There was a problem fetching projects: ' + error.message)
      })
  }
}
