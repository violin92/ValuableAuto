<style src="./styles/navigationBar.css"></style>


<template>
  <div id="app">
    <div id="nav">
      <p>
        <img alt="Vue logo" src="./assets/logo.png" />
      </p>
      <h1>Welcome to Valuabe Auto!</h1>
      <br />
      <ul>
        <li>
          <router-link to="/" class="bar">Home</router-link>
        </li>
        <li>
          <router-link to="/login" class="bar">Log in</router-link>
        </li>
        <li>
          <router-link to="/signup" class="bar">Sign up</router-link>
        </li>
        <li>
          <router-link to="/about">About</router-link>
        </li>
        <li>
          <router-link to="/trades">Trades</router-link>
        </li>
        <li>
          <router-link to="/filldb">Fill DB</router-link>
        </li>
        <li>
          <router-link to="/migrate">Migrate</router-link>
        </li>
        <li>
          <router-link to="/reports">Reports</router-link>
        </li>
      </ul>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
      info: "",
      username: "",
      userId: ""
    };
  },

  mounted() {},

  methods: {
    handleClick: function() {
      this.$router.replace({
        name: "search",
        params: { brand: this.brandEntered, model: this.modelEntered }
      });
    }
  }
};
</script>
