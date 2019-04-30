import BackendService from '@/services/BackendService.js'
import Vue from 'vue'

export const namespaced = true

export const state = {
  repositories: [],
  repositoriesDetails: [],
  selectedRepositories: [],
  // filter params for re3data search
  params: {}
}

export const mutations = {
  SET_REPOSITORIES (state, repositories) {
    state.repositories = repositories
  },
  SET_REPOSITORIES_DETAILS (state, repositoriesDetails) {
    state.repositoriesDetails = repositoriesDetails
  },
  ADD_REPOSITORY_DETAILS (state, repositoryDetails) {
    state.repositoriesDetails.push(repositoryDetails)
  },
  ADD_REPOSITORY_TO_SELECTION (state, repository) {
    state.selectedRepositories.findIndex(r => r.id === repository.id) === -1
      ? state.selectedRepositories.push(repository) : console.log('Repository already selected')
  },
  REMOVE_REPOSITORY_FROM_SELECTION (state, repository) {
    var index = state.selectedRepositories.findIndex(r => r.id === repository.id)
    index !== -1 ? state.selectedRepositories.splice(index, 1) : console.log('Repository not contained in selected repositories')
  },
  /*
  Using Vue.set to allow reactivity on nested objects
   */
  SET_FILTER_SEARCH_QUERY (state, query) {
    Vue.set(state.params, 'query', query)
  },
  SET_FILTER_SUBJECTS (state, subjects) {
    Vue.set(state.params, 'subjects', subjects)
  },
  SET_FILTER_CONTENT_TYPES (state, contentTypes) {
    Vue.set(state.params, 'contentTypes', contentTypes)
  },
  SET_FILTER_COUNTRIES (state, countries) {
    Vue.set(state.params, 'countries', countries)
  },
  SET_FILTER_CERTIFICATES (state, certificates) {
    Vue.set(state.params, 'certificates', certificates)
  },
  SET_FILTER_PID_SYSTEMS (state, pidSystems) {
    Vue.set(state.params, 'pidSystems', pidSystems)
  },
  SET_FILTER_AID_SYSTEMS (state, aidSystems) {
    Vue.set(state.params, 'aidSystems', aidSystems)
  },
  SET_FILTER_REPOSITORY_ACCESS (state, repositoryAccess) {
    Vue.set(state.params, 'databaseAccess', repositoryAccess)
  },
  SET_FILTER_DATA_ACCESS (state, dataAccess) {
    Vue.set(state.params, 'dataAccess', dataAccess)
  },
  SET_FILTER_VERSIONING (state, versioning) {
    Vue.set(state.params, 'versioning', versioning)
  },
  SET_FILTER_METADATA_STANDARDS (state, metadataStandards) {
    Vue.set(state.params, 'metadataStandards', metadataStandards)
  }
}

export const actions = {
  fetchRepositorySuggestions ({ commit, getters }) {
    return BackendService.getRepositorySuggestions(getters.getFilterParams)
      .then(response => {
        commit('SET_REPOSITORIES', response.data)
      })
      .catch(error => {
        console.log('There was a problem fetching repositories: ' + error.message)
      })
  },
  fetchRepositoryDetails ({ commit, getters }, repositoryId) {
    var repositoryDetails = getters.getRepositoryDetailsById(repositoryId)
    if (repositoryDetails) {
      return repositoryDetails
    } else {
      return BackendService.getRepositoryDetails(repositoryId).then(response => {
        commit('ADD_REPOSITORY_DETAILS', response.data)
        return response.data
      })
    }
  },
  selectRepository ({ commit }, repository) {
    if (repository) {
      commit('ADD_REPOSITORY_TO_SELECTION', repository)
    }
  },
  removeRepositoryFromSelection ({ commit }, repository) {
    if (repository) {
      commit('REMOVE_REPOSITORY_FROM_SELECTION', repository)
    }
  },
  clearRepositories ({ commit }) {
    commit('SET_REPOSITORIES', [])
    commit('SET_REPOSITORIES_DETAILS', [])
  },
  setFilterSearchQuery ({ commit }, query) {
    commit('SET_FILTER_SEARCH_QUERY', query)
  },
  setFilterSubjects ({ commit }, subjects) {
    commit('SET_FILTER_SUBJECTS', subjects)
  },
  setFilterContentTypes ({ commit }, contentTypes) {
    commit('SET_FILTER_CONTENT_TYPES', contentTypes)
  },
  setFilterCountries ({ commit }, countries) {
    commit('SET_FILTER_COUNTRIES', countries)
  },
  setFilterCertificates ({ commit }, certificates) {
    commit('SET_FILTER_CERTIFICATES', certificates)
  },
  setFilterPidSystems ({ commit }, pidSystems) {
    commit('SET_FILTER_PID_SYSTEMS', pidSystems)
  },
  setFilterAidSystems ({ commit }, aidSystems) {
    commit('SET_FILTER_AID_SYSTEMS', aidSystems)
  },
  setFilterRepositoryAccess ({ commit }, repositoryAccess) {
    commit('SET_FILTER_REPOSITORY_ACCESS', repositoryAccess)
  },
  setFilterDataAccess ({ commit }, dataAccess) {
    commit('SET_FILTER_DATA_ACCESS', dataAccess)
  },
  setFilterVersioning ({ commit }, versioning) {
    commit('SET_FILTER_VERSIONING', versioning)
  },
  setFilterMetadataStandards ({ commit }, metadataStandards) {
    commit('SET_FILTER_METADATA_STANDARDS', metadataStandards)
  }
}

export const getters = {
  getRepositoryDetailsById: state => repositoryId => {
    return state.repositoriesDetails.find(repositoryDetails => repositoryDetails.repositoryId === repositoryId)
  },
  getRepositorySuggestionsTotal: state => {
    return state.repositories.length
  },
  getRepositorySuggestionsPerPage: state => (page, perPage) => {
    var index = (page - 1) * perPage
    return state.repositories.slice(index, index + perPage)
  },
  getSelectedRepositoriesCount: state => {
    return state.selectedRepositories.length
  },
  getSelectedRepositories: state => {
    return state.selectedRepositories
  },
  isSelectedRepository: state => repositoryId => {
    return state.selectedRepositories.findIndex(r => r.id === repositoryId) !== -1
  },
  getFilterParams: state => {
    return state.params
  },
  getFilterSearchQuery: state => {
    return state.params.query
  },
  getFilterSubjects: state => {
    return state.params.subjects
  },
  getFilterContentTypes: state => {
    return state.params.contentTypes
  },
  getFilterCountries: state => {
    return state.params.countries
  },
  getFilterCertificates: state => {
    return state.params.certificates
  },
  getFilterPidSystems: state => {
    return state.params.pidSystems
  },
  getFilterAidSystems: state => {
    return state.params.aidSystems
  },
  getFilterRepositoryAccess: state => {
    return state.params.databaseAccess
  },
  getFilterDataAccess: state => {
    return state.params.dataAccess
  },
  getFilterVersioning: state => {
    return state.params.versioning
  },
  getFilterMetadataStandards: state => {
    return state.params.metadataStandards
  }
}
