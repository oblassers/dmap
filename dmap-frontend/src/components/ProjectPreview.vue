<template>
  <div style="position: relative; overflow: hidden;">
    <div class="project-overview">
      <h4>Project Title: {{ project.title }}</h4>
      <p>Project Duration: {{ project.projectStart | formatDate }} - {{ project.projectEnd | formatDate }}</p>
      <span>Fundings:</span>
      <ul>
        <li v-for="funding in project.fundings" :key="funding.funderName">
          {{ funding.funderName }}: {{ funding.fundingType }}
        </li>
      </ul>
    </div>
    <div class="project-description">
      <p>Short description: {{ project.description }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ProjectPreview',
  props: {
    project: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
.project-overview{
  text-align: left;
  float: left;
  width: 50%;
  padding: 20px;
}

.project-description{
  text-align: left;
  float: right;
  width: 50%;
  padding: 20px;
}
</style>
