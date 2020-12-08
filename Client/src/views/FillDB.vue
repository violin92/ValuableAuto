<style src="../styles/table.css"></style>

<template>
  <div class="home">
    <h1>Fill MySQL DB with Data</h1>
    <br />
    <button v-on:click="fillpersons" class="button searchButton">Fill DB with Persons</button>
    <br />
    <button v-on:click="addAppraiser" class="button searchButton">Add an appraiser</button>
    <br>
    <button v-on:click="fillvehicles" class="button searchButton">Fill DB with Vehicles</button>
    <br>
    <button v-on:click="filltrades" class="button searchButton">Fill DB with Trades</button>    
    <h3>{{info}}</h3>
    <h4>{{newEntries}}</h4>
  </div>
</template>

<script>
import axios from "axios";
import https from "https";

const httpsAgent = new https.Agent({
  rejectUnauthorized: false
});

export default {
  data() {
    return {
      info: "",
      newEntries : []
    };
  },

  methods: {
    fillpersons: async function() {
      this.info = "adding new persons ...";
      await axios
      .get(`https://localhost:5000/addPersons`, {
        httpsAgent
      })
      .then(
        result => {
          this.newEntries = result.data;
          
        },
        error => {
          this.info = error;
        }
      );
    },
    addAppraiser: async function() {
      this.info = "adding new appraiser ...";
      await axios
      .get(`https://localhost:5000/addAppraiser`, {
        httpsAgent
      })
      .then(
        result => {
          this.newEntries = result.data;
          
        },
        error => {
          this.info = error;
        }
      );
    },
    fillvehicles: async function() {
      this.info = "adding new vehicles ...";
      await axios
      .get(`https://localhost:5000/addVehicles`, {
        httpsAgent
      })
      .then(
        result => {
          this.newEntries = result.data;
          
        },
        error => {
          this.info = error;
        }
      );
    },
    filltrades: async function() {
      this.info = "adding new trades ...";
      await axios
      .get(`https://localhost:5000/addTrades`, {
        httpsAgent
      })
      .then(
        result => {
          this.newEntries = result.data;
          
        },
        error => {
          this.info = error;
        }
      );
    }
  }
};
</script>
