<template>
  <div>
    <p>Please indicate which metadata will be provided to help others identify, discover and reuse the data.</p>
    <v-textarea
      :value="getMetadata"
      @change="setMetadata"
      name="input-7-1"
      label="Metadata"
      box
      auto-grow
    ></v-textarea>

    <p>How will the research data be generated and which methods will be used?</p>
    <v-textarea
      :value="getDataGeneration"
      @change="setDataGeneration"
      name="input-7-1"
      label="Data generation"
      box
      auto-grow
    ></v-textarea>

    <p>How will you structure the data and handle versioning?</p>
    <v-textarea
      :value="getStructureAndVersioning"
      @change="setStructureAndVersioning"
      name="input-7-1"
      label="Structure and versioning"
      hint="E.g. use file naming convention that..., always provide a README file, etc"
      box
      auto-grow
    ></v-textarea>

    <p>Who is the target audience?</p>
    <v-textarea
      :value="getTargetAudience"
      @change="setTargetAudience"
      name="input-7-1"
      label="Target audience"
      box
      auto-grow
    ></v-textarea>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'Documentation',
  computed: {
    ...mapGetters('documentation', ['getMetadata', 'getDataGeneration',
      'getStructureAndVersioning', 'getTargetAudience'])
  },
  methods: {
    ...mapActions('documentation', ['setMetadata', 'setDataGeneration',
      'setStructureAndVersioning', 'setTargetAudience'])
  }
}
</script>

<style scoped>

</style>
