<style src="../styles/table.css"></style>

<template>
  <div class="home">
    <h1>Log in</h1>
    <form id="loginForm" @submit.prevent="login">
      <input v-model="username" type="text" placeholder="enter a username" />
      <br />
      <input v-model="password" type="password" placeholder="enter a password" />
      <p>
        <button type="submit" class="button searchButton">Log in</button>
      </p>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import https from "https";

export default {
  data() {
    return {
      username: "",
      password: ""
    };
  },

  methods: {
    login: function() {
      const httpsAgent = new https.Agent({
        rejectUnauthorized: false
      });

      if (this.username != "" && this.password != "") {
        axios
          .post(
            "https://localhost:8081/auth",
            {
              username: this.username,
              password: this.password
            },
            {
              httpsAgent: httpsAgent,
              headers: {
                "Content-Type": "application/json"
              }
            }
          )
          .then(response => {
            if (response.status === 200) {
              alert("You have successfully logged in!");
              localStorage.setItem("username", this.username);
              localStorage.setItem("userId", response.data.id);
              this.$router.replace({ name: "user" });
            }
          })
          .catch(error => {
            if (error.response.status === 401) {
              alert("The username and / or password is incorrect!");
            } else {
              alert(error);
            }
          });
      } else {
        alert("The username and / or password is empty!");
      }
    }
  }
};
</script>

