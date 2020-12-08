<template>
  <div id="form">
    <h1 align="center">My profile</h1>
    <h4>Username: {{username}}</h4>
    <h4>Name: {{name}}</h4>
    <h4>Date of birth: {{dateOfBirth}}</h4>
    <h4>address: {{address}}</h4>
    <h4>Phone: {{phone}}</h4>
    <h4>Mail: {{mail}}</h4>
    <br />
    <p align="center">
      <router-link to="/advertise" style="margin:auto">
        <button class="button searchButton">Advertise new vehicle</button>
      </router-link>
    </p>
    <p align="center">
      <router-link
        to="/vehicles/unapproved"
        v-if="$parent.username === 'appraiser'"
        style="margin:auto"
      >
        <button class="button searchButton">View unapproved vehicles</button>
      </router-link>
    </p>
  </div>
</template>

<script>
import axios from "axios";
import https from "https";

const httpsAgent = new https.Agent({
  rejectUnauthorized: false
});

export default {
  name: "home",
  data() {
    return {
      username: localStorage.getItem("username"),
      name: "",
      dateOfBirth: "",
      address: "",
      phone: "",
      mail: ""
    };
  },

  mounted() {
    this.username = localStorage.getItem("username");
    //if (this.$parent.username === "appraiser")
      axios
        .get(`https://localhost:8081/user/${this.username}`, {
          httpsAgent
        })
        .then(
          result => {
            (this.name = result.data.name),
              (this.dateOfBirth = result.data.dateOfBirth),
              (this.address = result.data.address),
              (this.phone = result.data.phone),
              (this.mail = result.data.mail);
          },
          error => {
            this.info = error;
          }
        );
  }
};
</script>
