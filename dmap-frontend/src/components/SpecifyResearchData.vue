<template>
  <div>
    <v-container fluid>
      <p>What kinds of research data will you create?</p>
      <v-radio-group v-model="radios" :mandatory="false">
        <v-radio label="Don't know yet" value="unknown"></v-radio>
        <v-radio label="No data will be created or analysed" value="nodata"></v-radio>
        <v-radio label="Specify with assistance" value="specify"></v-radio>
      </v-radio-group>
      <v-textarea
        v-show="radios === 'nodata'"
        name="input-7-1"
        box
        label="Please explain why you won't create or analyse any research data."
        auto-grow
        v-model="description"
      ></v-textarea>
      <ResearchDataEstimator
        v-show="radios === 'specify'"
      >
      </ResearchDataEstimator>
    </v-container>
  </div>
</template>

<script>
import ResearchDataEstimator from '@/components/ResearchDataEstimator'

export default {
  name: 'SpecifyResearchData',
  components: { ResearchDataEstimator },
  data () {
    return {
      radios: undefined,
      description: ''
    }
  }
}
</script>

<style scoped>

</style>
