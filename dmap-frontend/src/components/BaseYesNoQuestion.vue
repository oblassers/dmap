<template>
  <div>
    <p>{{ question }}</p>
    <v-radio-group v-model="radios" @change="answerSelected" :mandatory="false">
      <v-radio label="Yes" :value="true"></v-radio>
      <v-radio label="No" :value="false"></v-radio>
      <v-chip
        :value="radios !== undefined"
        @input="clearAnswer"
        close
        color="#039BE5"
        label
        outline
        small
      >Clear answer</v-chip>
    </v-radio-group>

    <slot></slot>

    <v-textarea
      v-if="showTextArea"
      name="input-7-1"
      box
      label="Please describe"
      auto-grow
      v-model="description"
      @change="textChanged"
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
  methods: {
    answerSelected (answer) {
      this.$emit('selection', answer)
    },
    textChanged (text) {
      this.$emit('textchange', text)
    },
    clearAnswer () {
      this.answerSelected(undefined)
      this.radios = undefined
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
