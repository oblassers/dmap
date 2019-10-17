<template>
  <v-card
    class="mx-auto"
    color="#f5f5f5"
  >
    <v-card-title>
      <h4>{{ repository.name }}</h4>
      <v-spacer></v-spacer>
      <v-btn
        @click="removeRepositoryFromSelection(repository)"
        flat
        icon
        class="ma-0"
      >
        <v-icon>cancel</v-icon>
      </v-btn>
    </v-card-title>
    <v-card-actions
      v-show="getDatasets.length > 0"
      class="px-3 py-0"
    >
      <v-select
        v-model="datasetsForDeposit"
        :items="getDatasets"
        item-value="datasetName"
        item-text="datasetName"
        label="Dataset(s) for deposit"
        multiple clearable chips deletable-chips
        class="mr-3"
      ></v-select>
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
            v-model="availableUntilDate"
            label="Available until"
            append-outer-icon="event"
            readonly
            v-on="on"
            class="mt-2 mr-1"
          ></v-text-field>
        </template>
        <v-date-picker v-model="availableUntilDate" @input="showDatePicker = false"></v-date-picker>
      </v-menu>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'RepositorySelected',
  props: {
    repository: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      showDatePicker: false
    }
  },
  computed: {
    ...mapGetters('data', ['getDatasetSummaries', 'getUnassignedDatasetSummary', 'getDatasets']),
    ...mapGetters('project', ['getLatestSelectedProjectEndDate']),
    ...mapGetters('repository', ['getDatasetsForDeposit', 'getAvailableUntilDate']),
    datasetsForDeposit: {
      set (datasetNames) {
        this.setDatasetsForDeposit({ repositoryId: this.repository.id, datasetNames: datasetNames })
      },
      get () {
        return this.getDatasetsForDeposit(this.repository.id)
      }
    },
    availableUntilDate: {
      set (date) {
        this.setAvailableUntilDate({ repositoryId: this.repository.id, availableUntil: date })
      },
      get () {
        return this.getAvailableUntilDate(this.repository.id)
      }
    }
  },
  methods: {
    ...mapActions('repository', ['removeRepositoryFromSelection', 'setDatasetsForDeposit', 'setAvailableUntilDate'])
  },
  mounted: function () {
    // by default set the available until date to project end date + 10 years
    let d = new Date(this.getLatestSelectedProjectEndDate)
    d.setFullYear(d.getFullYear() + 10)
    this.availableUntilDate = d.toISOString().substr(0, 10)
  }
}
</script>

<style scoped>

</style>
