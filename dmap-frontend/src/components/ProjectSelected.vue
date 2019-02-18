<template>
  <div>
    <div class="selected-project">
      <h4>{{ project.titleEn }} ({{ project.shortDescription }})</h4>
    </div>
    <div class="remove-btn">
      <v-btn flat icon large @click="removeProjectFromSelection(project)">
        <v-icon dark>cancel</v-icon>
      </v-btn>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'ProjectSelected',
  props: {
    project: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions('project', ['removeProjectFromSelection'])
  }
}
</script>

<style scoped>
  .selected-project{
    text-align: left;
    float: left;
    width: 90%;
  }

  .remove-btn{
    text-align: right;
    padding-right: 8px;
    background-color: lightgrey;
  }
</style>
