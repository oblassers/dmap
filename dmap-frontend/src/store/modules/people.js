export const namespaced = true

export const state = {
  dataManagementStaff: []
}

export const mutations = {
  ADD_DATA_MANAGEMENT_STAFF_MEMBER (state, person) {
    state.dataManagementStaff.findIndex(dmStaffMember =>
      dmStaffMember.personDetails.oid === person.personDetails.oid) === -1
      ? state.dataManagementStaff.push(
        Object.assign({}, {
          ...person,
          dataManagementRoles: []
        })) : console.log('Person already added to DM staff')
  },
  REMOVE_DATA_MANAGEMENT_STAFF_MEMBER (state, person) {
    var index = state.dataManagementStaff.findIndex(dmStaffMember =>
      dmStaffMember.personDetails.oid === person.personDetails.oid)
    index !== -1 ? state.dataManagementStaff.splice(index, 1) : console.log('Person not a member of DM staff')
  },
  SET_DATA_MANAGEMENT_ROLES (state, { oid, roles }) {
    let index = state.dataManagementStaff.findIndex(p => p.personDetails.oid === oid)
    index !== -1 ? state.dataManagementStaff[index].dataManagementRoles = roles
      : console.log('Person not contained in DM staff')
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
  },
  setDataManagementRoles ({ commit }, payload) {
    commit('SET_DATA_MANAGEMENT_ROLES', payload)
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
  },
  getDataManagementRoles: state => oid => {
    let index = state.dataManagementStaff.findIndex(p => p.personDetails.oid === oid)
    if (index > -1) {
      return state.dataManagementStaff[index].dataManagementRoles
    }
    return []
  }
}
