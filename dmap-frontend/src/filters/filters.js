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
  },
  formatSubject: (value) => {
    if (!value) return ''
    value = value.toString()
    return value.replace(/\d+|^\s+|\s+$/g, '')
  },
  formatStorageSize: (value) => {
    if (typeof value !== 'number') return ''
    if (value >= 1000000000000000000000000) {
      return Math.round(value / 1000000000000000000000000).toString() + 'YB'
    } else if (value >= 1000000000000000000000) {
      return Math.round(value / 1000000000000000000000).toString() + 'ZB'
    } else if (value >= 1000000000000000000) {
      return Math.round(value / 1000000000000000000).toString() + 'EB'
    } else if (value >= 1000000000000000) {
      return Math.round(value / 1000000000000000).toString() + 'PB'
    } else if (value >= 1000000000000) {
      return Math.round(value / 1000000000000).toString() + 'TB'
    } else if (value >= 1000000000) {
      return Math.round(value / 1000000000).toString() + 'GB'
    } else if (value >= 1000000) {
      return Math.round(value / 1000000).toString() + 'MB'
    } else if (value >= 1000) {
      return Math.round(value / 1000).toString() + 'kB'
    } else {
      return value.toString() + 'Byte'
    }
  }
}
