import BackendService from '@/services/BackendService.js'

export const namespaced = true

export const state = {
  projects: [],
  projectsDetails: [],
  selectedProjects: [],
  projectsStaff: []
}

export const mutations = {
  SET_PROJECTS (state, projects) {
    state.projects = projects
  },
  SET_PROJECTS_DETAILS (state, projectsDetails) {
    state.projectsDetails = projectsDetails
  },
  ADD_PROJECT_DETAILS (state, projectDetails) {
    state.projectsDetails.push(projectDetails)
  },
  ADD_PROJECT_TO_SELECTION (state, project) {
    state.selectedProjects.findIndex(p => p.projectId === project.projectId) === -1
      ? state.selectedProjects.push(project) : console.log('Project already selected')
  },
  REMOVE_PROJECT_FROM_SELECTION (state, project) {
    var index = state.selectedProjects.findIndex(p => p.projectId === project.projectId)
    index !== -1 ? state.selectedProjects.splice(index, 1) : console.log('Project not contained in selected projects')
  },
  SET_PROJECTS_STAFF (state, projectsStaff) {
    state.projectsStaff = projectsStaff
  },
  ADD_PROJECTS_STAFF (state, projectStaff) {
    projectStaff.forEach(projectMember => {
      state.projectsStaff.findIndex(pm => pm.personDetails.oid === projectMember.personDetails.oid) === -1
        ? state.projectsStaff.push(projectMember) : console.log('Project member already added')
    })
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
  },
  clearProjects ({ commit }) {
    commit('SET_PROJECTS', [])
    commit('SET_PROJECTS_DETAILS', [])
  },
  fetchProjectStaff ({ commit }, projectId) {
    return BackendService.getProjectStaff(projectId)
      .then(response => {
        commit('ADD_PROJECTS_STAFF', response.data)
      })
      .catch(error => {
        console.log('There was a problem fetching the project staff for projectid=' + projectId + ': ' + error.message)
      })
  },
  fetchProjectStaffForAllSelectedProjects ({ getters, dispatch }) {
    getters.getSelectedProjects.forEach(p => dispatch('fetchProjectStaff', p.projectId))
  },
  clearProjectsStaff ({ commit }) {
    commit('SET_PROJECTS_STAFF', [])
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
  },
  getSelectedProjects: state => {
    return state.selectedProjects
  },
  isSelectedProject: state => projectId => {
    return state.selectedProjects.findIndex(p => p.projectId === projectId) !== -1
  },
  getProjectsStaffCount: state => {
    return state.projectsStaff.length
  },
  getProjectsStaff: state => {
    return state.projectsStaff
  },
  getProjectsStaffPerPage: state => (page, perPage) => {
    var index = (page - 1) * perPage
    return state.projectsStaff.slice(index, index + perPage)
  },
  getLatestSelectedProjectEndDate: state => {
    var latestEndDate = new Date().toISOString().substr(0, 10)
    state.selectedProjects.forEach(p => {
      if (Date.parse(p.end) > Date.parse(latestEndDate)) {
        latestEndDate = p.end
      }
    })
    return latestEndDate
  }
}
