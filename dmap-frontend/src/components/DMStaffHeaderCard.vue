<template>
  <div>
    <div class="person-overview">
      <h4><v-icon>person</v-icon> {{ fullName }}</h4>
      <span>{{ person.roleInProject }}</span>
    </div>
    <div class="select-btn" @click.stop="addPersonToDataManagementStaff(person)">
      <v-btn :disabled="isMemberOfDataManagementStaff(person.personDetails.oid)" small>Select</v-btn>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'DMStaffHeaderCard',
  props: {
    person: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions('people', ['addPersonToDataManagementStaff'])
  },
  computed: {
    ...mapGetters('people', ['isMemberOfDataManagementStaff']),
    fullName () {
      return this.person.personDetails.first_name + ' ' + this.person.personDetails.last_name
    }
  }
}
</script>

<style scoped>
  .person-overview{
    text-align: left;
    float: left;
    width: 80%;
  }

  .select-btn{
    text-align: left;
    float: right;
  }
</style>
