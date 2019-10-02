import uuid from '@/utils/uuid'
import filters from '@/filters/filters'

function calculateTotalSize (estimations) {
  let sizeMin = 0
  let sizeMax = 0
  estimations.forEach(est => {
    sizeMin += est.estimatedSize.min
    sizeMax += est.estimatedSize.max
  })
  return Object.assign({}, {
    totalSizeMin: sizeMin,
    totalSizeMax: sizeMax,
    dataEstimations: estimations
  })
}

function mapSampleDataEstimation (estimation) {
  let totalSize = estimation.size * estimation.amount
  return Object.assign({}, {
    id: estimation.id,
    selectedDataset: estimation.selectedDataset,
    comment: estimation.comment,
    estimatedType: {
      label: estimation.format,
      description: estimation.formatIdentifier.id
    },
    estimatedSize: {
      label: filters.formatStorageSize(totalSize),
      max: totalSize,
      min: totalSize
    }
  })
}

export const namespaced = true

export const state = {
  dataCreation: undefined,
  noDataExplanation: '',
  datasetNames: [],
  // manual data estimations
  dataEstimations: [],
  editedDataEstimationIndex: -1,
  editedDataEstimationItem: {
    estimatedType: {},
    estimatedSize: {},
    selectedDataset: '',
    comment: ''
  },
  // sample data estimations from file upload
  sampleDataEstimations: [],
  editedSampleDataEstimationIndex: -1,
  editedSampleDataEstimationItem: {
    format: '',
    mimeType: '',
    formatIdentifier: {},
    size: 0,
    amount: 1,
    selectedDataset: '',
    comment: ''
  }
}

export const mutations = {
  SET_DATA_CREATION (state, text) {
    state.dataCreation = text
  },
  SET_NO_DATA_EXPLANATION (state, text) {
    state.noDataExplanation = text
  },
  SET_DATASET_NAMES (state, names) {
    state.datasetNames = names
  },
  UPDATE_DATASET_NAMES_ON_DATA_ESTIMATIONS (state) {
    state.dataEstimations.forEach(est => {
      if (!state.datasetNames.includes(est.selectedDataset)) {
        est.selectedDataset = ''
      }
    })
    state.sampleDataEstimations.forEach(est => {
      if (!state.datasetNames.includes(est.selectedDataset)) {
        est.selectedDataset = ''
      }
    })
  },
  SAVE_DATA_ESTIMATION (state) {
    if (state.editedDataEstimationIndex > -1) {
      Object.assign(state.dataEstimations[state.editedDataEstimationIndex], state.editedDataEstimationItem)
    } else {
      state.dataEstimations.push(
        Object.assign({}, {
          id: uuid.uuidv4(),
          ...state.editedDataEstimationItem })
      )
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
  ADD_SAMPLE_DATA_ESTIMATION (state, estimation) {
    state.sampleDataEstimations.push(
      Object.assign({}, {
        id: uuid.uuidv4(),
        amount: 1,
        selectedDataset: '',
        comment: '',
        ...estimation
      })
    )
  },
  SAVE_EDITED_SAMPLE_DATA_ESTIMATION (state) {
    if (state.editedSampleDataEstimationIndex > -1) {
      Object.assign(state.sampleDataEstimations[state.editedSampleDataEstimationIndex],
        state.editedSampleDataEstimationItem)
    }
  },
  REMOVE_SAMPLE_DATA_ESTIMATION (state, estimation) {
    const index = state.sampleDataEstimations.indexOf(estimation)
    if (index > -1) {
      state.sampleDataEstimations.splice(index, 1)
    }
  },
  SET_EDITED_SAMPLE_DATA_ESTIMATION_ITEM (state, estimation) {
    state.editedSampleDataEstimationIndex = state.sampleDataEstimations.indexOf(estimation)
    state.editedSampleDataEstimationItem = Object.assign({}, estimation)
  }
}

export const actions = {
  setDataCreation ({ commit }, text) {
    commit('SET_DATA_CREATION', text)
  },
  setNoDataExplanation ({ commit }, text) {
    commit('SET_NO_DATA_EXPLANATION', text)
  },
  setDatasetNames ({ commit }, names) {
    commit('SET_DATASET_NAMES', names)
    commit('UPDATE_DATASET_NAMES_ON_DATA_ESTIMATIONS')
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
  addSampleDataEstimation ({ commit }, estimation) {
    commit('ADD_SAMPLE_DATA_ESTIMATION', estimation)
  },
  saveEditedSampleDataEstimation ({ commit }) {
    commit('SAVE_EDITED_SAMPLE_DATA_ESTIMATION')
  },
  removeSampleDataEstimation ({ commit }, estimation) {
    commit('REMOVE_SAMPLE_DATA_ESTIMATION', estimation)
  },
  setEditedSampleDataEstimationItem ({ commit }, estimation) {
    commit('SET_EDITED_SAMPLE_DATA_ESTIMATION_ITEM', estimation)
  },
  resetEditedSampleDataEstimationItem ({ commit }) {
    commit('SET_EDITED_SAMPLE_DATA_ESTIMATION_ITEM', {
      format: '',
      mimeType: '',
      formatIdentifier: {},
      size: 0,
      amount: 1,
      selectedDataset: '',
      comment: ''
    })
  }
}

export const getters = {
  getDataCreation: state => {
    return state.dataCreation
  },
  getNoDataExplanation: state => {
    return state.noDataExplanation
  },
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
  getDatasetSummaries: state => {
    let datasetSummaries = []
    state.datasetNames.forEach(name => {
      let estimationsPerName = state.dataEstimations.filter(estimation => estimation.selectedDataset === name)
      let sampleEstimationsPerName = state.sampleDataEstimations.filter(estimation => estimation.selectedDataset === name)
      let mappedSampleEstimationsPerName = []
      sampleEstimationsPerName.forEach(estimation => {
        mappedSampleEstimationsPerName.push(mapSampleDataEstimation(estimation))
      })
      Array.prototype.push.apply(estimationsPerName, mappedSampleEstimationsPerName)

      if (estimationsPerName.length > 0) {
        datasetSummaries.push(Object.assign({}, {
          datasetName: name,
          ...calculateTotalSize(estimationsPerName)
        }))
      }
    })
    return datasetSummaries
  },
  getUnassignedDatasetSummary: state => {
    let unassignedEstimations = state.dataEstimations.filter(
      estimation => !state.datasetNames.includes(estimation.selectedDataset))
    let unassignedSampleDataEstimations = state.sampleDataEstimations.filter(
      estimation => !state.datasetNames.includes(estimation.selectedDataset))
    let mappedUnassignedSampleDataEstimations = []
    unassignedSampleDataEstimations.forEach(estimation => {
      mappedUnassignedSampleDataEstimations.push(mapSampleDataEstimation(estimation))
    })
    Array.prototype.push.apply(unassignedEstimations, mappedUnassignedSampleDataEstimations)

    return Object.assign({}, {
      datasetName: 'Unassigned data',
      ...calculateTotalSize(unassignedEstimations)
    })
  },
  getDatasets: (state, getters) => {
    if (getters.getUnassignedDatasetSummary.dataEstimations.length > 0) {
      return getters.getDatasetSummaries.concat(getters.getUnassignedDatasetSummary)
    }
    return getters.getDatasetSummaries
  },
  getSampleDataEstimations: state => {
    return state.sampleDataEstimations
  },
  getSampleDataEstimationsCount: state => {
    return state.sampleDataEstimations.length
  },
  getEditedSampleDataEstimationItem: state => {
    return state.editedSampleDataEstimationItem
  }
}
