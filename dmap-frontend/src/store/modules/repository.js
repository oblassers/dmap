import BackendService from '@/services/BackendService.js'

export const namespaced = true

export const state = {
  repositories: [],
  repositoriesDetails: [],
  selectedRepositories: []
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
  }
}

export const actions = {
  fetchRepositorySuggestions ({ commit }, query) {
    return BackendService.getRepositorySuggestions(query)
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
  }
}
