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

    <v-dialog v-model="showDialog" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">Edit Sample Data Estimation</span>
        </v-card-title>

        <v-card-text>
          <v-form ref="form" v-model="formValid" lazy-validation>
            <v-container grid-list-md>
              <v-layout wrap>
                <v-flex xs12 sm10 md10>
                  <v-list-tile-content>
                    <v-list-tile-sub-title class="v-label v-label--active theme--light">Format</v-list-tile-sub-title>
                    <v-list-tile-title class="sample-file">{{ editedItem.format }}</v-list-tile-title>
                  </v-list-tile-content>
                </v-flex>
                <v-flex xs12 sm2 md2>
                  <v-list-tile-content>
                    <v-list-tile-sub-title class="v-label v-label--active theme--light">Size</v-list-tile-sub-title>
                    <v-list-tile-title class="sample-file">{{ editedItem.size | formatStorageSize }}</v-list-tile-title>
                  </v-list-tile-content>
                </v-flex>
                <v-flex xs12 sm12 md12>
                  <v-list-tile-content v-if="editedItem.formatIdentifier.id !== 'unknown'">
                    <v-list-tile-sub-title class="v-label v-label--active theme--light">Format ID</v-list-tile-sub-title>
                    <v-list-tile-title class="sample-file">{{ editedItem.formatIdentifier.id }}</v-list-tile-title>
                  </v-list-tile-content>
                </v-flex>
                <v-flex xs12 sm6 md6>
                  <v-tooltip top>
                    <template v-slot:activator="{ on }">
                      <v-text-field
                        v-model.number="editedItem.amount"
                        label="Amount"
                        type="number"
                        min="0"
                        class="mt-0"
                        oninput="validity.valid||(value=0);"
                        v-on="on"
                      >
                      </v-text-field>
                    </template>
                    <span>How many similar files will you create?</span>
                  </v-tooltip>
                </v-flex>
                <v-flex xs12 sm6 md6>
                  <v-text-field
                    :value="editedItemTotalSize | formatStorageSize"
                    label="Total size"
                    readonly
                  >
                  </v-text-field>
                </v-flex>
                <v-flex xs12 sm12 md12>
                  <v-select
                    v-model="editedItem.selectedDataset"
                    :items="getDatasetNames"
                    :disabled="getDatasetNames.length === 0"
                    label="Belongs to dataset"
                    class="px-0"
                  >
                  </v-select>
                </v-flex>
                <v-flex xs12 sm12 md12>
                  <v-text-field
                    v-model="editedItem.comment"
                    label="Comment"
                    box
                  ></v-text-field>
                </v-flex>
              </v-layout>
            </v-container>
          </v-form>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="close">Cancel</v-btn>
          <v-btn color="blue darken-1" flat @click="save" :disabled="!formValid">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-data-table
      :headers="headers"
      :items="getSampleDataEstimations"
      v-if="getSampleDataEstimations.length > 0"
    >
      <template v-slot:items="props">
        <td>{{ props.item.format }}</td>
        <td class="text-xs-left">{{ props.item.formatIdentifier.id }}</td>
        <td class="text-xs-center">{{ props.item.size | formatStorageSize }}</td>
        <td class="text-xs-center">{{ props.item.amount }}</td>
        <td class="text-xs-center">{{ props.item.amount * props.item.size | formatStorageSize }}</td>
        <td class="text-xs-center">{{ props.item.selectedDataset }}</td>
        <td class="text-xs-left">{{ props.item.comment }}</td>
        <td class="justify-center layout px-0">
          <v-icon
            small
            class="mr-2"
            @click="editItem(props.item)"
          >
            edit
          </v-icon>
          <v-icon
            small
            @click="deleteItem(props.item)"
          >
            delete
          </v-icon>
        </td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import vueDropzone from 'vue2-dropzone'
import 'vue2-dropzone/dist/vue2Dropzone.min.css'
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'FileAnalysis',
  components: {
    vueDropzone
  },
  data () {
    return {
      showDialog: false,
      formValid: false,
      headers: [
        { text: 'Format', value: 'format', align: 'left' },
        { text: 'Format ID', value: 'formatId', align: 'left' },
        { text: 'Size', value: 'size', align: 'center' },
        { text: 'Amount', value: 'amount', align: 'center' },
        { text: 'Total', value: 'total', align: 'center' },
        { text: 'Dataset', value: 'selectedDataset', align: 'center' },
        { text: 'Comment', value: 'comment', align: 'left' },
        { text: 'Actions', value: 'format', align: 'center' }
      ],
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
  computed: {
    ...mapGetters('data', ['getDatasetNames', 'getSampleDataEstimations', 'getEditedSampleDataEstimationItem']),
    editedItem: {
      set (item) {
        this.setEditedSampleDataEstimationItem(item)
      },
      get () {
        return this.getEditedSampleDataEstimationItem
      }
    },
    editedItemTotalSize () {
      return this.editedItem.amount * this.editedItem.size
    }
  },
  methods: {
    ...mapActions('data', ['addSampleDataEstimation', 'setEditedSampleDataEstimationItem',
      'removeSampleDataEstimation', 'resetEditedSampleDataEstimationItem', 'saveEditedSampleDataEstimation']),
    async processFileAnalysisResult (file, response) {
      await this.sleep(1000)
      this.$refs.myDropzone.removeFile(file)
      this.addSampleDataEstimation(response)
    },
    sleep (ms) {
      return new Promise(resolve => setTimeout(resolve, ms))
    },
    editItem (item) {
      this.editedItem = item
      this.showDialog = true
    },
    deleteItem (item) {
      confirm('Are you sure you want to delete this sample data estimation?') && this.removeSampleDataEstimation(item)
    },
    close () {
      this.showDialog = false
      setTimeout(() => {
        this.resetEditedSampleDataEstimationItem()
        this.$refs.form.resetValidation()
      }, 300)
    },
    save () {
      if (this.$refs.form.validate()) {
        this.saveEditedSampleDataEstimation()
        this.close()
      }
    }
  }
}
</script>

<style scoped>
.vue-dropzone {
  border: 2px dashed #e5e5e5;
}
.sample-file {
  font-size: 16px;
}
</style>
