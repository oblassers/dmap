<template>
  <div>
    <v-combobox v-model="datasetNames"
                label="Create names for your datasets"
                multiple chips deletable-chips clearable
    >
    </v-combobox>
    <p>Estimate the type, format and volume of your research data manually and / or by uploading
      sample data and group them into datasets.
    </p>
    <v-tabs
      v-model="activeTab"
      color="#f5f5f5"
      slider-color="primary"
    >
      <v-tab :href="`#tab-manual`">Manually</v-tab>
      <v-tab :href="`#tab-auto`">Uploading sample data</v-tab>

      <v-tabs-items
        v-model="activeTab"
      >
        <v-tab-item :value="`tab-manual`">
          <ManualDataEstimator></ManualDataEstimator>
        </v-tab-item>
        <v-tab-item :value="`tab-auto`">
          <FileAnalysis></FileAnalysis>
        </v-tab-item>
      </v-tabs-items>
    </v-tabs>
    <v-container fluid grid-list-lg>
      <v-layout row wrap>
        <v-flex v-for="dataset in getDatasetSummaries" :key="dataset.datasetName" xs12 sm6 md6 lg4>
          <DatasetSummary :dataset="dataset"></DatasetSummary>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import ManualDataEstimator from '@/components/ManualDataEstimator'
import FileAnalysis from '@/components/FileAnalysis'
import DatasetSummary from '@/components/DatasetSummary'

export default {
  name: 'ResearchDataEstimator',
  components: {
    DatasetSummary,
    ManualDataEstimator,
    FileAnalysis
  },
  data () {
    return {
      activeTab: 'tab-manual'
    }
  },
  computed: {
    ...mapGetters('data', ['getDatasetNames', 'getDatasetSummaries']),
    datasetNames: {
      set (names) {
        this.setDatasetNames(names)
      },
      get () {
        return this.getDatasetNames
      }
    }
  },
  methods: {
    ...mapActions('data', ['setDatasetNames'])
  }
}
</script>

<style scoped>

</style>
