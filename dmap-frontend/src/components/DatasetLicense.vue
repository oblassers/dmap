<template>
  <v-card color="#f5f5f5">
    <v-card-title class="pb-0">
      <v-container fluid class="pa-0">
        <v-layout row>
          <v-flex xs6 sm8 md9 lg10 class="pb-0">
            <h4>{{ distribution.datasetName }}</h4>
          </v-flex>
          <v-flex xs6 sm4 md3 lg2 class="pb-0">
            <v-switch v-model="dataAccess" color="primary" class="pa-0 ma-0"
                      :label="dataAccess ? 'publish' : 'keep closed'"
            ></v-switch>
          </v-flex>
        </v-layout>
      </v-container>
    </v-card-title>

    <v-card-text v-show="dataAccess" class="py-0">
      <v-textarea
        v-if="licenseName === 'Other'"
        name="input-7-1"
        box
        label="Please describe your license"
        hint="You may want to include external links"
        auto-grow
        v-model="otherLicenseDescription"
      ></v-textarea>
      <p v-else>{{ licenseDescription }}</p>
    </v-card-text>

    <v-card-actions class="px-3" v-show="dataAccess">
      <v-select
        v-model="selectedLicense"
        :items="licenses"
        :hint="licenseHint"
        item-text="name"
        return-object
        label="Planned license"
        persistent-hint
      ></v-select>
      <LicenseSelector
        @input="selectLicense"
        @license-definitions="setLicenseDefinitions"
        class="mr-2"
        v-once
      ></LicenseSelector>
      <v-menu
        v-model="showDatePicker"
        :close-on-content-click="false"
        :nudge-right="40"
        lazy
        transition="scale-transition"
        offset-y
        full-width
        min-width="290px"
      >
        <template v-slot:activator="{ on }">
          <v-text-field
            v-model="licenseActiveDate"
            label="Planned to be active from"
            append-outer-icon="event"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker v-model="licenseActiveDate" @input="showDatePicker = false"></v-date-picker>
      </v-menu>
    </v-card-actions>
  </v-card>
</template>

<script>
import LicenseSelector from '@/components/LicenseSelectorWrapper'
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'DatasetLicense',
  components: { LicenseSelector },
  props: {
    distribution: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      showDatePicker: false,
      licenses: [
        {
          name: 'Other',
          url: '',
          description: ''
        }
      ]
    }
  },
  computed: {
    ...mapGetters('project', ['getLatestSelectedProjectEndDate']),
    ...mapGetters('license', ['getDataAccess', 'getLicense', 'getLicenseActiveDate', 'getOtherLicenseDescription']),
    dataAccess: {
      set (access) {
        this.setDataAccess({ datasetName: this.distribution.datasetName, access: access })
      },
      get () {
        return this.getDataAccess(this.distribution.datasetName)
      }
    },
    selectedLicense: {
      set (license) {
        this.setLicense({ datasetName: this.distribution.datasetName, license: license })
      },
      get () {
        return this.getLicense(this.distribution.datasetName)
      }
    },
    licenseActiveDate: {
      set (activeDate) {
        this.setLicenseActiveDate({ datasetName: this.distribution.datasetName, activeDate: activeDate })
      },
      get () {
        return this.getLicenseActiveDate(this.distribution.datasetName)
      }
    },
    otherLicenseDescription: {
      set (licenseDescription) {
        this.setOtherLicenseDescription(
          {
            datasetName: this.distribution.datasetName,
            licenseDescription: licenseDescription
          })
      },
      get () {
        return this.getOtherLicenseDescription(this.distribution.datasetName)
      }
    },
    licenseHint: function () {
      if (this.selectedLicense) {
        return this.selectedLicense.url !== '' ? ' See also ' + this.selectedLicense.url : ''
      }
      return ''
    },
    licenseDescription: function () {
      return this.selectedLicense ? this.selectedLicense.description : ''
    },
    licenseName: function () {
      return this.selectedLicense ? this.selectedLicense.name : ''
    }
  },
  methods: {
    ...mapActions('license', ['setDataAccess', 'setLicense', 'setLicenseActiveDate', 'setOtherLicenseDescription']),
    selectLicense (license) {
      this.selectedLicense = license
    },
    setLicenseDefinitions (licenses) {
      this.licenses.unshift(...licenses)
      if (this.selectedLicense === undefined) {
        // set CC-0 by default
        this.selectedLicense = this.licenses.find(l => {
          return l.key === 'cc-zero'
        })
      }
    }
  },
  mounted: function () {
    // by default set the license active date to project end date
    this.licenseActiveDate = this.getLatestSelectedProjectEndDate
  }
}
</script>

<style scoped>

</style>
