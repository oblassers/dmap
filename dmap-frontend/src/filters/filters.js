import moment from 'moment'

export default {
  formatDateTime: (value) => {
    if (!value) return ''
    value = value.toString()
    return moment(value).format('DD.MM.YYYY kk:mm:ss')
  },
  formatDate: (value) => {
    if (!value) return ''
    value = value.toString()
    return moment(value).format('DD.MM.YYYY')
  }
}
