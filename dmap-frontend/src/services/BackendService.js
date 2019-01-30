import axios from 'axios'

const apiClient = axios.create({
  baseURL: 'http://localhost:3000/api/',
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  },
  timeout: 10000
})

export default {
  getDmps () {
    return apiClient.get('/dmps/')
  }
}
