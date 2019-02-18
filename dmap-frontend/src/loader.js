import NProgress from 'nprogress'
import store from '@/store/store'

NProgress.configure({ easing: 'ease', speed: 500, showSpinner: true })

store.watch(
  state => state.loading.loading,
  (newVal, oldVal) => {
    if (newVal === 0) return NProgress.done()
    if (oldVal === 0) return NProgress.start()
  }
)
