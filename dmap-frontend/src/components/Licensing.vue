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
        <v-flex v-for="dataset in getDatasets" :key="dataset.datasetName" xs12 sm12 md12 lg12>
          <DatasetLicense :dataset="dataset"></DatasetLicense>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import DatasetLicense from '@/components/DatasetLicense'
import { mapGetters } from 'vuex'

export default {
  name: 'Licensing',
  components: { DatasetLicense },
  computed: {
    ...mapGetters('data', ['getDatasets'])
  }
}
</script>

<style scoped>

</style>
