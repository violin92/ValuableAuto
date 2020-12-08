<style src="../styles/table.css"></style>

<template>
  <div class="home">
    <h1>Search results:</h1>
    <table>
      <thead>
        <tr>
          <th>
            Brand
            <span class="arrow"></span>
          </th>
          <th>
            Model
            <span class="arrow"></span>
          </th>
          <th>
            Engine
            <span class="arrow"></span>
          </th>
          <th>
            Date of Registration
            <span class="arrow"></span>
          </th>
          <th>
            Price
            <span class="arrow"></span>
          </th>
          <th>
            <span class="arrow"></span>
          </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="vehicle in results" v-bind:key="vehicle">
          <td>{{vehicle.brand}}</td>
          <td>{{vehicle.model}}</td>
          <td>{{vehicle.engine}}</td>
          <td>{{vehicle.dateOfRegistration}}</td>
          <td>{{vehicle.price}}</td>
          <td>
            <button
              v-on:click="buy(vehicle.id)"
              class="seeButton searchButton"
            >Buy</button>
          </td>
        </tr>
      </tbody>
    </table>

    <p>
      <button v-on:click="back" class="button searchButton">Edit search</button>
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
  props: {
    brand: {
      type: String,
      default: "Vue!"
    },
    model: {
      type: String,
      default: "Vue!"
    }
  },
  data() {
    return {
      columns: [{}],
      results: []      
    };
  },

  mounted() {    

    axios.get(`https://localhost:8081/findVehicles?brand=${this.brand}&model=${this.model}`, { httpsAgent }).then(
      result => {
        this.results = result.data;
      },
      error => {
        this.info = error;
      }
    );
  },

  methods: {
    back: function() {
      this.$router.go(-1);
    },
    buy: async function(vehicleId) {
      if (localStorage.userId != null && localStorage.userId != "") {
        await axios
          .post(
            `https://localhost:8081/trade`,
            {
              buyerId: localStorage.getItem("userId"),
              vehicleId: vehicleId
            },
            {
              httpsAgent: httpsAgent,
              headers: {
                "Content-Type": "application/json"
              }
            }
          )
          .then(() => {
            alert("You bought the vehicle successfully!");
          })
          .catch(e => {
            alert(e);
          });
      } else {
        alert("You are not logged in!");
      }
    }
  }
};
</script>
