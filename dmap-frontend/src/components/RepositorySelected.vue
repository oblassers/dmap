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
      v-show="datasets.length > 0"
      class="px-3 py-0"
    >
      <v-select
        :items="datasets"
        return-object
        item-text="datasetName"
        label="Dataset(s) for deposit"
        multiple chips
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
            v-model="date"
            label="Available until"
            append-outer-icon="event"
            readonly
            v-on="on"
            class="mt-2 mr-1"
          ></v-text-field>
        </template>
        <v-date-picker v-model="date" @input="showDatePicker = false"></v-date-picker>
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
      date: new Date().toISOString().substr(0, 10),
      showDatePicker: false
    }
  },
  computed: {
    ...mapGetters('data', ['getDatasetSummaries', 'getUnassignedDatasetSummary']),
    datasets () {
      if (this.getUnassignedDatasetSummary.dataEstimations.length > 0) {
        return this.getDatasetSummaries.concat(this.getUnassignedDatasetSummary)
      }
      return this.getDatasetSummaries
    }
  },
  methods: {
    ...mapActions('repository', ['removeRepositoryFromSelection'])
  }
}
</script>

<style scoped>

</style>
