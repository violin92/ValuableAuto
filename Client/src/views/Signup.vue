<style src="../styles/combobox.css"></style>

<template>
  <div>
    <h1>Sign up</h1>
    <form id="signUpForm" @submit.prevent="signup">
      <input v-model="username" type="text" placeholder="enter a username" />     
      <br />
      <input v-model="password" type="password" placeholder="enter a password" />
      <br />
      <input v-model="name" type="text" placeholder="enter your name" />
      <br />
      <input v-model="dateOfBirth" type="date" placeholder="enter your date of birth (yyyy-mm-dd)" />
      <br />
      <input v-model="address" type="text" placeholder="enter your adress" />
      <br />
      <input v-model="phone" type="tel" placeholder="enter your phone" />
      <br />
      <input v-model="mail" type="email" placeholder="enter your mail" />
      <br />
      <select v-model="paymentMethod" class="select-selected">
        <option disabled value>Please select payment method</option>
        <option value="LASTSCHRIFT">Lastschrift</option>
        <option value="UEBERWEISUNG">Überweisung</option>
        <option value="PAYPAL">PayPal</option>
      </select>
      <br />
      <br />
      <button type="submit" class="button searchButton">Sign up</button>
    </form>
    <h3>{{info}}</h3>
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
      info: null,
      paymentMethod: ""
    };
  },

  methods: {
    signup: async function() {
      this.info = "saving ...";
      await axios
        .post(
          `https://localhost:8081/signUp`,
          {
            username: this.username,
            password: this.password,
            name: this.name,
            dateOfBirth: this.dateOfBirth,
            address: this.address,
            phone: this.phone,
            mail: this.mail,
            personType: "USER",
            saldo: "0.00",
            paymentMethod: this.paymentMethod
          },
          {
            httpAgent: httpsAgent,
            headers: {
              "Content-Type": "application/json"
            }
          }
        )
        .then(() => {
          this.info = "You were registrated successfully!";
        })
        .catch(error => {
          this.info = "Error: " + error.response.data;
        });
    }
  }
};
</script>

