import axios from 'axios'
import store from '@/store/store'

const apiClient = axios.create({
  baseURL: 'http://localhost:3000/api/',
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  },
  timeout: 15000
})

apiClient.interceptors.request.use(config => {
  store.dispatch('loading/startLoading')
  return config
})

apiClient.interceptors.response.use(response => {
  store.dispatch('loading/finishLoading')
  return response
})

export default {
  getDmps () {
    return apiClient.get('/dmps')
  },
  getDmp (id) {
    return apiClient.get('/dmps/' + id)
  },
  createNewDmp (dmp) {
    return apiClient.post('/dmps', dmp)
  },
  getProjectSuggestions (user) {
    return apiClient.post('/pdb/suggest_projects', user)
  },
  getProjectDetails (projectId) {
    return apiClient.get('/pdb/project/' + projectId)
  },
  getProjectStaff (projectId) {
    return apiClient.get('pdb/project/' + projectId + '/staff')
  },
  getRepositorySuggestions () {
    return apiClient.get('repository_registry/search')
  }
}
