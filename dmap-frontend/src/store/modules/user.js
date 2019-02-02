export const namespaced = true

export const state = {
  user: {
    oid: '1026725',
    firstName: 'Andreas',
    lastName: 'Rauber',
    orgs: [
      {
        tiss_id: '4758',
        code: 'E194-01'
      }
    ]
  }
}

export const getters = {
  getFullName: state => {
    return state.user.firstName + ' ' + state.user.lastName
  }
}
