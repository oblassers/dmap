<template>
  <v-layout row wrap>
    <v-flex xs12>
      <slot></slot>
    </v-flex>
    <v-flex xs12 mt-3 mb-2>
      <v-btn v-if="previousStep" color="primary" @click="gotoStep(previousStep)" small>Previous step</v-btn>
      <v-btn v-if="nextStep" color="primary" @click="gotoStep(nextStep)" small>Next step</v-btn>
    </v-flex>
  </v-layout>
</template>

<script>
export default {
  name: 'BaseStepContent',
  props: {
    previousStep: {
      type: String,
      required: false
    },
    nextStep: {
      type: String,
      required: false
    }
  },
  methods: {
    gotoStep: function (step) {
      this.$emit('gotoStep', { step: step })
    }
  }
}
</script>

<style scoped>

</style>
