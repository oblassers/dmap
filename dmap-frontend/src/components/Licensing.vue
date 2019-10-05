<template>
  <div>
    <p>
      Please indicate which datasets you plan to keep closed or publish.
      Select a license for the datasets you want to publish and estimate the release date.
    </p>
    <div class="text-xs-center">
      <v-alert
        :value="getDatasets.length === 0"
        icon="info"
        color="info"
        outline
      >
        No datasets are specified yet. Please specify research data first.
      </v-alert>
    </div>
    <v-container fluid grid-list-lg>
      <v-layout row wrap>
        <v-flex v-for="distribution in getDistributions" :key="distribution.datasetName" xs12 sm12 md12 lg12>
          <DatasetLicense :distribution="distribution"></DatasetLicense>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import DatasetLicense from '@/components/DatasetLicense'
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'Licensing',
  components: { DatasetLicense },
  computed: {
    ...mapGetters('data', ['getDatasets']),
    ...mapGetters('license', ['getDistributions'])
  },
  methods: {
    ...mapActions('license', ['updateDistributions'])
  },
  watch: {
    getDatasets: function (datasets) {
      this.updateDistributions(datasets.map(d => d.datasetName))
    }
  }
}
</script>

<style scoped>

</style>
