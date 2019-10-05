<template>
  <div>
    <p>What kinds of research data will you create?</p>
    <v-radio-group v-model="dataCreation" :mandatory="false">
      <v-radio label="Don't know yet" value="unknown"></v-radio>
      <v-radio label="No data will be created or analysed" value="nodata"></v-radio>
      <v-radio label="Specify with assistance" value="specify"></v-radio>
    </v-radio-group>
    <v-textarea
      v-show="dataCreation === 'nodata'"
      :value="getNoDataExplanation"
      @change="setNoDataExplanation"
      name="input-7-1"
      box
      label="Please explain why you won't create or analyse any research data."
      auto-grow
    ></v-textarea>
    <ResearchDataEstimator
      v-show="dataCreation === 'specify'"
    >
    </ResearchDataEstimator>
  </div>
</template>

<script>
import ResearchDataEstimator from '@/components/ResearchDataEstimator'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'SpecifyResearchData',
  components: { ResearchDataEstimator },
  computed: {
    ...mapGetters('data', ['getNoDataExplanation', 'getDataCreation']),
    dataCreation: {
      set (text) {
        this.setDataCreation(text)
      },
      get () {
        return this.getDataCreation
      }
    }
  },
  methods: {
    ...mapActions('data', ['setNoDataExplanation', 'setDataCreation'])
  }
}
</script>

<style scoped>

</style>
