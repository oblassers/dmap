export const namespaced = true

export const state = {
  isDataSensitive: undefined,
  isDataSensitiveDescription: '',
  containsPersonalInformation: undefined,
  containsPersonalInformationDescription: '',
  hasLegalIssues: undefined,
  hasLegalIssuesDescription: '',
  hasEthicalIssues: undefined,
  approvedByEthicalBoard: undefined,
  linkToEthicsReport: '',
  ethicalComplianceStatement: ''
}

export const mutations = {
  SET_IS_DATA_SENSITIVE (state, isSensitive) {
    state.isDataSensitive = isSensitive
  },
  SET_IS_DATA_SENSITIVE_DESCRIPTION (state, description) {
    state.isDataSensitiveDescription = description
  },
  SET_CONTAINS_PERSONAL_INFORMATION (state, containsPersonalInfo) {
    state.containsPersonalInformation = containsPersonalInfo
  },
  SET_CONTAINS_PERSONAL_INFORMATION_DESCRIPTION (state, description) {
    state.containsPersonalInformationDescription = description
  },
  SET_HAS_LEGAL_ISSUES (state, hasLegalIssues) {
    state.hasLegalIssues = hasLegalIssues
  },
  SET_HAS_LEGAL_ISSUES_DESCRIPTION (state, description) {
    state.hasLegalIssuesDescription = description
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
  setIsDataSensitiveDescription ({ commit }, description) {
    commit('SET_IS_DATA_SENSITIVE_DESCRIPTION', description)
  },
  setContainsPersonalInformation ({ commit }, containsPersonalInfo) {
    commit('SET_CONTAINS_PERSONAL_INFORMATION', containsPersonalInfo)
  },
  setContainsPersonalInformationDescription ({ commit }, description) {
    commit('SET_CONTAINS_PERSONAL_INFORMATION_DESCRIPTION', description)
  },
  setHasLegalIssues ({ commit }, hasLegalIssues) {
    commit('SET_HAS_LEGAL_ISSUES', hasLegalIssues)
  },
  setHasLegalIssuesDescription ({ commit }, description) {
    commit('SET_HAS_LEGAL_ISSUES_DESCRIPTION', description)
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
  getDataSensitiveDescription: state => {
    return state.isDataSensitiveDescription
  },
  containsPersonalInformation: state => {
    return state.containsPersonalInformation
  },
  getContainsPersonalInformationDescription: state => {
    return state.containsPersonalInformationDescription
  },
  hasLegalIssues: state => {
    return state.hasLegalIssues
  },
  getLegalIssuesDescription: state => {
    return state.hasLegalIssuesDescription
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
  GetEthicalComplianceStatement: state => {
    return state.ethicalComplianceStatement
  },
  getLegalAndEthicalInfoProvided: state => {
    return state.isDataSensitive !== undefined || state.isDataSensitiveDescription !== '' ||
      state.containsPersonalInformation !== undefined || state.containsPersonalInformationDescription !== '' ||
      state.hasLegalIssues !== undefined || state.hasLegalIssuesDescription !== '' ||
      state.hasEthicalIssues !== undefined || state.approvedByEthicalBoard !== undefined ||
      state.linkToEthicsReport !== '' || state.ethicalComplianceStatement !== ''
  }
}
