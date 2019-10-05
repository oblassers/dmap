export const namespaced = true

export const state = {
  isDataSensitive: undefined,
  sensitiveDatasets: [],
  dataSensitiveDescription: '',
  containsPersonalInformation: undefined,
  datasetsWithPersonalInformation: [],
  containsPersonalInformationDescription: '',
  hasLegalIssues: undefined,
  legalIssuesDescription: '',
  hasEthicalIssues: undefined,
  approvedByEthicalBoard: undefined,
  linkToEthicsReport: '',
  ethicalComplianceStatement: ''
}

export const mutations = {
  SET_IS_DATA_SENSITIVE (state, isSensitive) {
    state.isDataSensitive = isSensitive
  },
  SET_SENSITIVE_DATASETS (state, datasets) {
    state.sensitiveDatasets = datasets
  },
  UPDATE_SENSITIVE_DATASETS (state, allDatasetNames) {
    state.sensitiveDatasets = state.sensitiveDatasets.filter(d => allDatasetNames.includes(d))
  },
  SET_DATA_SENSITIVE_DESCRIPTION (state, description) {
    state.dataSensitiveDescription = description
  },
  SET_CONTAINS_PERSONAL_INFORMATION (state, containsPersonalInfo) {
    state.containsPersonalInformation = containsPersonalInfo
  },
  SET_DATASETS_WITH_PERSONAL_INFORMATION (state, datasets) {
    state.datasetsWithPersonalInformation = datasets
  },
  UPDATE_DATASETS_WITH_PERSONAL_INFORMATION (state, allDatasetNames) {
    state.datasetsWithPersonalInformation =
      state.datasetsWithPersonalInformation.filter(d => allDatasetNames.includes(d))
  },
  SET_CONTAINS_PERSONAL_INFORMATION_DESCRIPTION (state, description) {
    state.containsPersonalInformationDescription = description
  },
  SET_HAS_LEGAL_ISSUES (state, hasLegalIssues) {
    state.hasLegalIssues = hasLegalIssues
  },
  SET_LEGAL_ISSUES_DESCRIPTION (state, description) {
    state.legalIssuesDescription = description
  },
  SET_HAS_ETHICAL_ISSUES (state, hasEthicalIssues) {
    state.hasEthicalIssues = hasEthicalIssues
  },
  SET_APPROVED_BY_ETHICAL_BOARD (state, approvedByEthicalBoard) {
    state.approvedByEthicalBoard = approvedByEthicalBoard
  },
  SET_LINK_TO_ETHICS_REPORT (state, linkToEthicsReport) {
    state.linkToEthicsReport = linkToEthicsReport
  },
  SET_ETHICAL_COMPLIANCE_STATEMENT (state, statement) {
    state.ethicalComplianceStatement = statement
  }
}

export const actions = {
  setIsDataSensitive ({ commit }, isSensitive) {
    commit('SET_IS_DATA_SENSITIVE', isSensitive)
  },
  setSensitiveDatasets ({ commit }, datasets) {
    commit('SET_SENSITIVE_DATASETS', datasets)
  },
  updateSensitiveDatasets ({ commit }, allDatasetNames) {
    commit('UPDATE_SENSITIVE_DATASETS', allDatasetNames)
  },
  setDataSensitiveDescription ({ commit }, description) {
    commit('SET_DATA_SENSITIVE_DESCRIPTION', description)
  },
  setContainsPersonalInformation ({ commit }, containsPersonalInfo) {
    commit('SET_CONTAINS_PERSONAL_INFORMATION', containsPersonalInfo)
  },
  setDatasetsWithPersonalInformation ({ commit }, datasets) {
    commit('SET_DATASETS_WITH_PERSONAL_INFORMATION', datasets)
  },
  updateDatasetsWithPersonalInformation ({ commit }, allDatasetNames) {
    commit('UPDATE_DATASETS_WITH_PERSONAL_INFORMATION', allDatasetNames)
  },
  setContainsPersonalInformationDescription ({ commit }, description) {
    commit('SET_CONTAINS_PERSONAL_INFORMATION_DESCRIPTION', description)
  },
  setHasLegalIssues ({ commit }, hasLegalIssues) {
    commit('SET_HAS_LEGAL_ISSUES', hasLegalIssues)
  },
  setLegalIssuesDescription ({ commit }, description) {
    commit('SET_LEGAL_ISSUES_DESCRIPTION', description)
  },
  setHasEthicalIssues ({ commit }, hasEthicalIssues) {
    commit('SET_HAS_ETHICAL_ISSUES', hasEthicalIssues)
  },
  setApprovedByEthicalBoard ({ commit }, approvedByEthicalBoard) {
    commit('SET_APPROVED_BY_ETHICAL_BOARD', approvedByEthicalBoard)
  },
  setLinkToEthicsReport ({ commit }, linkToEthicsReport) {
    commit('SET_LINK_TO_ETHICS_REPORT', linkToEthicsReport)
  },
  setEthicalComplianceStatement ({ commit }, statement) {
    commit('SET_ETHICAL_COMPLIANCE_STATEMENT', statement)
  }
}

export const getters = {
  isDataSensitive: state => {
    return state.isDataSensitive
  },
  getSensitiveDatasets: state => {
    return state.sensitiveDatasets
  },
  getDataSensitiveDescription: state => {
    return state.dataSensitiveDescription
  },
  containsPersonalInformation: state => {
    return state.containsPersonalInformation
  },
  getDatasetsWithPersonalInformation: state => {
    return state.datasetsWithPersonalInformation
  },
  getContainsPersonalInformationDescription: state => {
    return state.containsPersonalInformationDescription
  },
  hasLegalIssues: state => {
    return state.hasLegalIssues
  },
  getLegalIssuesDescription: state => {
    return state.legalIssuesDescription
  },
  hasEthicalIssues: state => {
    return state.hasEthicalIssues
  },
  getApprovedByEthicalBoard: state => {
    return state.approvedByEthicalBoard
  },
  getLinkToEthicsReport: state => {
    return state.linkToEthicsReport
  },
  getEthicalComplianceStatement: state => {
    return state.ethicalComplianceStatement
  },
  getLegalAndEthicalInfoProvided: state => {
    return state.isDataSensitive !== undefined || state.dataSensitiveDescription !== '' ||
      state.containsPersonalInformation !== undefined || state.containsPersonalInformationDescription !== '' ||
      state.hasLegalIssues !== undefined || state.legalIssuesDescription !== '' ||
      state.hasEthicalIssues !== undefined || state.approvedByEthicalBoard !== undefined ||
      state.linkToEthicsReport !== '' || state.ethicalComplianceStatement !== ''
  }
}
