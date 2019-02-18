import BackendService from '@/services/BackendService.js'

export const namespaced = true

export const state = {
  projects: [],
  projectsDetails: [],
  selectedProjects: []
}

export const mutations = {
  SET_PROJECTS (state, projects) {
    state.projects = projects
  },
  ADD_PROJECT_DETAILS (state, projectDetails) {
    state.projectsDetails.push(projectDetails)
  },
  ADD_PROJECT_TO_SELECTION (state, project) {
    state.selectedProjects.indexOf(project) === -1
      ? state.selectedProjects.push(project) : console.log('Project already selected')
  },
  REMOVE_PROJECT_FROM_SELECTION (state, project) {
    var index = state.selectedProjects.indexOf(project)
    index !== -1 ? state.selectedProjects.splice(index, 1) : console.log('Project not contained in selected projects')
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
  },
  fetchProjectDetails ({ commit, getters }, projectId) {
    var projectDetails = getters.getProjectDetailsById(projectId)
    if (projectDetails) {
      return projectDetails
    } else {
      return BackendService.getProjectDetails(projectId).then(response => {
        commit('ADD_PROJECT_DETAILS', response.data)
        return response.data
      })
    }
  },
  selectProject ({ commit }, project) {
    if (project) {
      commit('ADD_PROJECT_TO_SELECTION', project)
    }
  },
  removeProjectFromSelection ({ commit }, project) {
    if (project) {
      commit('REMOVE_PROJECT_FROM_SELECTION', project)
    }
  }
}

export const getters = {
  getProjectDetailsById: state => projectId => {
    return state.projectsDetails.find(projectDetails => projectDetails.id === projectId)
  },
  getProjectSuggestionsTotal: state => {
    return state.projects.length
  },
  getProjectSuggestionsPerPage: state => (page, perPage) => {
    var index = (page - 1) * perPage
    return state.projects.slice(index, index + perPage)
  },
  getSelectedProjectsCount: state => {
    return state.selectedProjects.length
  }
}
