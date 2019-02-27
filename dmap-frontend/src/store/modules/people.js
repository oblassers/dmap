export const namespaced = true

export const state = {
  dataManagementStaff: []
}

export const mutations = {
  ADD_DATA_MANAGEMENT_STAFF_MEMBER (state, person) {
    state.dataManagementStaff.findIndex(dmStaffMember =>
      dmStaffMember.personDetails.oid === person.personDetails.oid) === -1
      ? state.dataManagementStaff.push(person) : console.log('Person already added to DM staff')
  },
  REMOVE_DATA_MANAGEMENT_STAFF_MEMBER (state, person) {
    var index = state.dataManagementStaff.findIndex(dmStaffMember =>
      dmStaffMember.personDetails.oid === person.personDetails.oid)
    index !== -1 ? state.dataManagementStaff.splice(index, 1) : console.log('Person not a member of DM staff')
  }
}

export const actions = {
  addPersonToDataManagementStaff ({ commit }, person) {
    if (person) {
      commit('ADD_DATA_MANAGEMENT_STAFF_MEMBER', person)
    }
  },
  removePersonFromDataManagementStaff ({ commit }, person) {
    if (person) {
      commit('REMOVE_DATA_MANAGEMENT_STAFF_MEMBER', person)
    }
  }
}

export const getters = {
  getDataManagementStaffMembersCount: state => {
    return state.dataManagementStaff.length
  },
  getDataManagementStaff: state => {
    return state.dataManagementStaff
  },
  isMemberOfDataManagementStaff: state => oid => {
    return state.dataManagementStaff.findIndex(p => p.personDetails.oid === oid) !== -1
  }
}
