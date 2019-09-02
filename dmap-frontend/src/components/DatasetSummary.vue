<template>
  <v-card class="card">
    <v-card-title>
      <v-container fluid class="pa-0">
        <v-layout row justify-space-between>
          <v-flex>
            <h4>{{ dataset.datasetName }}</h4>
          </v-flex>
          <v-flex text-xs-right>
            <v-icon>description</v-icon>
          </v-flex>
        </v-layout>
      </v-container>
    </v-card-title>
    <v-card-actions class="px-3">
      <span v-if="dataset.totalSizeMin === 0 && dataset.totalSizeMax === 0" class="title font-weight-light">
        ?
      </span>
      <span v-else-if="!dataset.totalSizeMax" class="title font-weight-light">
        &gt; {{ dataset.totalSizeMin | formatStorageSize }}
      </span>
      <span v-else-if="dataset.totalSizeMin === 0" class="title font-weight-light">
        &lt; {{ dataset.totalSizeMax | formatStorageSize }}
      </span>
      <span v-else class="title font-weight-light">
        {{ dataset.totalSizeMin | formatStorageSize }} - {{ dataset.totalSizeMax | formatStorageSize }}
      </span>
      <v-spacer></v-spacer>
      <v-btn icon @click="show = !show">
        <v-icon>{{ show ? 'keyboard_arrow_down' : 'keyboard_arrow_up' }}</v-icon>
      </v-btn>
    </v-card-actions>
    <v-slide-y-transition>
      <v-card-text v-show="show">
        <v-list two-line class="list">
          <template v-for="(estimation, index) in dataset.dataEstimations">
            <v-list-tile :key="estimation.id" class="tile">
              <v-list-tile-content>
                <v-list-tile-title>{{ estimation.estimatedType.label }}</v-list-tile-title>
                <v-list-tile-sub-title>{{ estimation.comment }}</v-list-tile-sub-title>
              </v-list-tile-content>
              <v-list-tile-action>
                <v-list-tile-action-text>{{ estimation.estimatedSize.label }}</v-list-tile-action-text>
              </v-list-tile-action>
            </v-list-tile>
            <v-divider
              v-if="index + 1 < dataset.dataEstimations.length"
              :key="index"
            ></v-divider>
          </template>
        </v-list>
      </v-card-text>
    </v-slide-y-transition>
  </v-card>
</template>

<script>
export default {
  name: 'DatasetSummary',
  props: {
    dataset: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      show: false
    }
  }
}
</script>

<style scoped>
.tile {
  background: #f5f5f5;
}
.list {
  background: #f5f5f5;
}
.card {
  background: #f5f5f5;
}
</style>
