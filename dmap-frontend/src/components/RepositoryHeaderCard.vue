<template>
  <div>
    <div class="repository-overview">
      <h4>{{ repository.name }}</h4>
    </div>
    <div class="select-btn" @click.stop="selectRepository(repository)">
      <v-btn :disabled="isSelectedRepository(repository.id)" small>Select</v-btn>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'RepositoryHeaderCard',
  props: {
    repository: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions('repository', ['selectRepository'])
  },
  computed: {
    ...mapGetters('repository', ['isSelectedRepository'])
  }
}
</script>

<style scoped>
.repository-overview{
  text-align: left;
  float: left;
  width: 80%;
}
.select-btn{
  text-align: left;
  float: right;
}
</style>
