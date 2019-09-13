export const namespaced = true

export const state = {
  metadata: '',
  dataGeneration: '',
  structureAndVersioning: '',
  targetAudience: ''
}

export const mutations = {
  SET_METADATA (state, text) {
    state.metadata = text
  },
  SET_DATA_GENERATION (state, text) {
    state.dataGeneration = text
  },
  SET_STRUCTURE_AND_VERSIONING (state, text) {
    state.structureAndVersioning = text
  },
  SET_TARGET_AUDIENCE (state, text) {
    state.targetAudience = text
  }
}

export const actions = {
  setMetadata ({ commit }, text) {
    commit('SET_METADATA', text)
  },
  setDataGeneration ({ commit }, text) {
    commit('SET_DATA_GENERATION', text)
  },
  setStructureAndVersioning ({ commit }, text) {
    commit('SET_STRUCTURE_AND_VERSIONING', text)
  },
  setTargetAudience ({ commit }, text) {
    commit('SET_TARGET_AUDIENCE', text)
  }
}

export const getters = {
  getMetadata: state => {
    return state.metadata
  },
  getDataGeneration: state => {
    return state.dataGeneration
  },
  getStructureAndVersioning: state => {
    return state.structureAndVersioning
  },
  getTargetAudience: state => {
    return state.targetAudience
  }
}
