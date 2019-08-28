<template>
  <div>
    <vue-dropzone
      ref="myDropzone"
      id="dropzone"
      :options="dropzoneOptions"
      :useCustomSlot="true"
      @vdropzone-success="processFileAnalysisResult"
    >
      <div class="dropzone-custom-content">
        <v-icon large>backup</v-icon>
        <div class="dropzone-custom-title">Drop files here to analyze</div>
      </div>
    </vue-dropzone>
  </div>
</template>

<script>
import vueDropzone from 'vue2-dropzone'
import 'vue2-dropzone/dist/vue2Dropzone.min.css'

export default {
  name: 'FileAnalysis',
  components: {
    vueDropzone
  },
  data () {
    return {
      dropzoneOptions: {
        /* TODO: Change this to use vuex and axios instead of url here */
        url: 'http://localhost:3000/api/file-analysis/examine',
        timeout: 120000,
        createImageThumbnails: false,
        maxFilesize: 2000, // MB
        addRemoveLinks: true
      }
    }
  },
  methods: {
    async processFileAnalysisResult (file, response) {
      console.log('success')
      await this.sleep(1000)
      this.$refs.myDropzone.removeFile(file)
    },
    sleep (ms) {
      return new Promise(resolve => setTimeout(resolve, ms))
    }
  }
}
</script>

<style scoped>
.vue-dropzone {
  border: 2px dashed #e5e5e5;
}
</style>
