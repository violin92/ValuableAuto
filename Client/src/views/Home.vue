<style src="../styles/table.css"></style>

<template>
  <div class="home">
    <h1> Looking for a new car ? {{username}}</h1>
    <input v-model="brandEntered" placeholder="enter brand"> <br>
      <input v-model="modelEntered" placeholder="enter model">
      <br>
      <button v-on:click="handleClick" class="button searchButton">Search</button>
  </div>
</template>

<script>

export default {
  name: 'home',
  mounted() {
    if (this.$cookies.get('valuableAuto_username')) {
      this.username = this.$cookies.get('valuableAuto_username');
    }
    },
  methods: {
    handleClick: function() {
      this.$router.push({ name: 'search', params: { brand: this.brandEntered, model: this.modelEntered } })

    }
  }
}
</script>
