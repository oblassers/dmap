<template>
  <div>
    <p>Please indicate which metadata will be provided to help others identify, discover and reuse the data.</p>
    <v-textarea
      name="input-7-1"
      label="Metadata"
      box
      auto-grow
      v-model="metadata"
    ></v-textarea>

    <p>How will the research data be generated and which methods will be used?</p>
    <v-textarea
      name="input-7-1"
      label="Data generation"
      box
      auto-grow
      v-model="dataGeneration"
    ></v-textarea>

    <p>How will you structure the data and handle versioning?</p>
    <v-textarea
      name="input-7-1"
      label="Structure and versioning"
      hint="E.g. use file naming convention that..., always provide a README file, etc"
      box
      auto-grow
      v-model="structureAndVersioning"
    ></v-textarea>

    <p>Who is the target audience?</p>
    <v-textarea
      name="input-7-1"
      label="Target audience"
      box
      auto-grow
      v-model="targetAudience"
    ></v-textarea>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'Documentation',
  computed: {
    ...mapGetters('documentation', ['getMetadata', 'getDataGeneration',
      'getStructureAndVersioning', 'getTargetAudience']),
    metadata: {
      set (text) {
        this.setMetadata(text)
      },
      get () {
        return this.getMetadata
      }
    },
    dataGeneration: {
      set (text) {
        this.setDataGeneration(text)
      },
      get () {
        return this.getDataGeneration
      }
    },
    structureAndVersioning: {
      set (text) {
        this.setStructureAndVersioning(text)
      },
      get () {
        return this.getStructureAndVersioning
      }
    },
    targetAudience: {
      set (text) {
        this.setTargetAudience(text)
      },
      get () {
        return this.getTargetAudience
      }
    }
  },
  methods: {
    ...mapActions('documentation', ['setMetadata', 'setDataGeneration',
      'setStructureAndVersioning', 'setTargetAudience'])
  }
}
</script>

<style scoped>

</style>
