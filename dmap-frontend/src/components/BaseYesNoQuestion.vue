<template>
  <div>
    <p>{{ question }}</p>
    <v-radio-group v-model="radios" :mandatory="false">
      <v-radio label="Yes" :value="true"></v-radio>
      <v-radio label="No" :value="false"></v-radio>
    </v-radio-group>
    <v-textarea
      v-if="showTextArea"
      name="input-7-1"
      box
      label="Please describe"
      auto-grow
      v-model="description"
    ></v-textarea>
  </div>
</template>

<script>
export default {
  name: 'BaseYesNoQuestion',
  props: {
    question: {
      type: String,
      required: true
    },
    withText: Boolean,
    onYes: Boolean
  },
  data () {
    return {
      radios: undefined,
      description: ''
    }
  },
  computed: {
    showTextArea () {
      return this.withText && ((this.onYes && this.radios) || (!this.onYes && this.radios === false))
    }
  }
}
</script>

<style scoped>

</style>
