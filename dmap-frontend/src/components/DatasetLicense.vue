<template>
  <v-card color="#f5f5f5">
    <v-card-title class="pb-0">
      <v-container fluid class="pa-0">
        <v-layout row>
          <v-flex xs6 sm8 md9 lg10 class="pb-0">
            <h4>{{ dataset.datasetName }}</h4>
          </v-flex>
          <v-flex xs6 sm4 md3 lg2 class="pb-0">
            <v-switch v-model="publish" color="primary" class="pa-0 ma-0"
                      :label="publish ? 'publish' : 'keep closed'"
            ></v-switch>
          </v-flex>
        </v-layout>
      </v-container>
    </v-card-title>

    <v-card-text v-show="publish" class="py-0">
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

    <v-card-actions class="px-3" v-show="publish">
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
        @input="setLicense"
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
            v-model="date"
            label="Planned to be active from"
            append-outer-icon="event"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker v-model="date" @input="showDatePicker = false"></v-date-picker>
      </v-menu>
    </v-card-actions>
  </v-card>
</template>

<script>
import LicenseSelector from '@/components/LicenseSelectorWrapper'

export default {
  name: 'DatasetLicense',
  components: { LicenseSelector },
  props: {
    dataset: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      publish: false,
      date: new Date().toISOString().substr(0, 10),
      showDatePicker: false,
      otherLicenseDescription: '',
      selectedLicense: undefined,
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
    setLicense (license) {
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
  }
}
</script>

<style scoped>

</style>
