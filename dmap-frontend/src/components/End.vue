<template>
  <div>
    <p>Congratulations, you successfully created an initial DMP!
      Now you can select an export type and download the DMP or send it directly to your funder.
    </p>
    <v-card flat>
      <v-card-actions class="pl-0">
        <v-select
          v-model="selectedExportType"
          :items="exportTypes"
          label="Select export type"
          item-text="name"
          return-object
          class="mr-3"
        >
          <template slot="selection" slot-scope="data">
            <v-list-tile-content>
              <v-list-tile-title>{{ data.item.name }}</v-list-tile-title>
              <v-list-tile-sub-title v-if="data.item.format">({{ data.item.format }})</v-list-tile-sub-title>
            </v-list-tile-content>
          </template>
          <template slot="item" slot-scope="data">
            <v-list-tile-content>
              <v-list-tile-title>{{ data.item.name }}</v-list-tile-title>
              <v-list-tile-sub-title v-if="data.item.format">({{ data.item.format }})</v-list-tile-sub-title>
            </v-list-tile-content>
          </template>
        </v-select>

        <v-btn
          small
          @click="saveDmp"
        >
          <v-icon small>arrow_downward</v-icon><span class="ml-1">Download DMP</span>
        </v-btn>

        <v-btn
          small
          @click="submitToFunder"
          :loading="sending"
          :disabled="sending"
        >
          <v-icon small>send</v-icon><span class="ml-1">Submit DMP to funder</span>
        </v-btn>
      </v-card-actions>
    </v-card>
    <span
      v-if="latestSubmissionTime"
    >
      Latest submission: {{ latestSubmissionTime | formatDateTime }}
    </span>

    <v-snackbar
      v-model="showSuccessMessage"
      bottom right
      color="success"
    >
      DMP successfully submitted to funder!
      <v-btn
        flat
        @click="showSuccessMessage = false"
      >
        Close
      </v-btn>
    </v-snackbar>
  </div>
</template>

<script>
import { saveAs } from 'file-saver'
import { mapActions } from 'vuex'

export default {
  name: 'End',
  data () {
    return {
      showSuccessMessage: false,
      sending: false,
      latestSubmissionTime: '',
      selectedExportType: undefined,
      exportTypes: [
        {
          key: 'rda-dmp-common',
          name: 'RDA DMP Common Standard',
          format: 'JSON'
        }
      ]
    }
  },
  methods: {
    ...mapActions('rda', ['constructRdaDmpCommonStandard']),
    saveDmp () {
      if (this.selectedExportType.key === 'rda-dmp-common') {
        this.constructRdaDmpCommonStandard().then(dmp => {
          let blob = new Blob([JSON.stringify(dmp, null, 2)], { type: 'application/json;charset=utf-8' })
          saveAs(blob, 'rda-common-dmp.json')
        })
      }
    },
    submitToFunder () {
      // Dummy send to nowhere for demo
      if (confirm('Are you sure you want to submit the DMP to your funder?')) {
        this.sending = true
        setTimeout(() => {
          this.sending = false
          this.showSuccessMessage = true
          this.latestSubmissionTime = new Date().toISOString()
        }, 2000)
      }
    }
  },
  mounted: function () {
    // by default set the export type to RDA DMP Common Standard
    this.selectedExportType = this.exportTypes.find(t => {
      return t.key === 'rda-dmp-common'
    })
  }
}
</script>

<style scoped>

</style>
