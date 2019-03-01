<template>
  <div>
    <p>
      <span v-for="(question, index) in questions" :key="index">{{ question }}<br></span>
    </p>
    <v-textarea
      name="input-7-1"
      box
      label="Description"
      auto-grow
      v-model="description"
      @change="setFurtherDataDescription(description)"
    ></v-textarea>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'DescribeResearchData',
  props: {
    furtherDescription: {
      type: String,
      required: false
    }
  },
  data () {
    return {
      questions: [
        'How will the research data be generated and which methods will be used?',
        'How will you structure the data and handle versioning?',
        'Who is the target audience?'
      ],
      description: this.furtherDescription
    }
  },
  methods: {
    ...mapActions('data', ['setFurtherDataDescription'])
  }
}
</script>

<style scoped>

</style>
