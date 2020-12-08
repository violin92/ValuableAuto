<template>
  <div>
    <h1>Advertise new vehicle</h1>
    <input v-model="brand" placeholder="enter a brand" />
    <br />
    <input v-model="model" placeholder="enter a model" />
    <br />
    <input v-model="engine" placeholder="enter an engine" />
    <br />
    <input v-model="hp" type="number" placeholder="enter hourse power" />
    <br />
    <input v-model="dateOfRegistration" type="date" placeholder="enter date of registration (yyyy-mm-dd)" />
    <br />
    <input v-model="color" placeholder="enter a color" />
    <br />
    <input v-model="price" type="number" placeholder="enter a price" />
    <br />
    <br />
    <button v-on:click="publish" class="button searchButton">Publish</button>
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
      info: null
    };
  },

  methods: {
    publish: async function() {
      this.info = "saving ...";
      await axios
        .post(
          `https://localhost:8081/addVehicle`,
          {
            brand: this.brand,
            model: this.model,
            engine: this.engine,
            hp: this.hp,
            dateOfRegistration: this.dateOfRegistration,
            color: this.color,
            price: this.price,
            seller: {
              id: localStorage.getItem("userId"),
            }
          },
          {
            httpsAgent: httpsAgent,
            headers: {
              "Content-Type": "application/json"
            }
          }
        )
        .then(() => {
          this.info = "Your advertise was published successfully!";
        })
        .catch(e => {
          this.info = e;
        });
    }
  }
};
</script>
