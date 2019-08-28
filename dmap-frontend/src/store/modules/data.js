export const namespaced = true

export const state = {
  datasetNames: ['Default'],
  dataEstimations: [],
  editedDataEstimationIndex: -1,
  editedDataEstimationItem: {
    estimatedType: {},
    estimatedSize: {},
    selectedDataset: '',
    comment: ''
  },
  furtherDataDescription: ''
}

export const mutations = {
  SET_DATASET_NAMES (state, names) {
    state.datasetNames = names
  },
  SAVE_DATA_ESTIMATION (state) {
    if (state.editedDataEstimationIndex > -1) {
      Object.assign(state.dataEstimations[state.editedDataEstimationIndex], state.editedDataEstimationItem)
    } else {
      state.dataEstimations.push(state.editedDataEstimationItem)
    }
  },
  REMOVE_DATA_ESTIMATION (state, estimation) {
    const index = state.dataEstimations.indexOf(estimation)
    if (index > -1) {
      state.dataEstimations.splice(index, 1)
    }
  },
  SET_EDITED_DATA_ESTIMATION_ITEM (state, estimation) {
    state.editedDataEstimationIndex = state.dataEstimations.indexOf(estimation)
    state.editedDataEstimationItem = Object.assign({}, estimation)
  },
  SET_FURTHER_DATA_DESCRIPTION (state, description) {
    state.furtherDataDescription = description
  }
}

export const actions = {
  setDatasetNames ({ commit }, names) {
    commit('SET_DATASET_NAMES', names)
  },
  saveDataEstimation ({ commit }) {
    commit('SAVE_DATA_ESTIMATION')
  },
  removeDataEstimation ({ commit }, estimation) {
    commit('REMOVE_DATA_ESTIMATION', estimation)
  },
  setEditedDataEstimationItem ({ commit }, estimation) {
    commit('SET_EDITED_DATA_ESTIMATION_ITEM', estimation)
  },
  resetEditedDataEstimationItem ({ commit }) {
    commit('SET_EDITED_DATA_ESTIMATION_ITEM', {
      estimatedType: {},
      estimatedSize: {},
      selectedDataset: '',
      comment: ''
    })
  },
  setFurtherDataDescription ({ commit }, description) {
    commit('SET_FURTHER_DATA_DESCRIPTION', description)
  }
}

export const getters = {
  getDatasetNames: state => {
    return state.datasetNames
  },
  getDataEstimations: state => {
    return state.dataEstimations
  },
  getEditedDataEstimationItem: state => {
    return state.editedDataEstimationItem
  },
  beingEdited: state => {
    return state.editedDataEstimationIndex > -1
  },
  getDataEstimationsCount: state => {
    return state.dataEstimations.length
  },
  getFurtherDataDescription: state => {
    return state.furtherDataDescription
  }
}
