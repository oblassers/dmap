<template>
  <div>
    <div class="selected-person">
      <h4>{{ person.personDetails.first_name }}</h4>
    </div>
    <div class="remove-btn">
      <v-btn flat icon large @click="removePersonFromDataManagementStaff(person)">
        <v-icon dark>cancel</v-icon>
      </v-btn>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'PersonSelected',
  props: {
    person: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions('people', ['removePersonFromDataManagementStaff'])
  }
}
</script>

<style scoped>
.selected-person{
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
