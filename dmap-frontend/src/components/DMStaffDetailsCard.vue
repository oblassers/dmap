<template>
  <div class="person-details">
    <div>
      <v-icon small>mail_outline</v-icon>
      <a :href="'mailto:' + person.personDetails.main_email" class="person-email">{{ person.personDetails.main_email }}
      </a>
    </div>
    <div><v-icon small>phone</v-icon> {{ person.personDetails.main_phone_number }}</div>
    <div v-for="(employment, index) in person.personDetails.employee" :key="index">
      {{ employment.org_ref.code }}: {{ employment.org_ref.name_en }}
    </div>
  </div>
</template>

<script>

export default {
  name: 'DMStaffDetailsCard',
  props: {
    person: {
      type: Object,
      required: true
    }
  },
  computed: {
    email () {
      return this.person.personDetails.main_email
    }
  }
}
</script>

<style scoped>
.person-details{
  padding-left: 23px;
}
.person-email{
  margin-left: 6px;
}
</style>
