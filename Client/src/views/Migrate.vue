<style src="../styles/table.css"></style>

<template>
  <div class="home">
    <h1>Migrate to MongoBD</h1>
    <br />
    <button v-on:click="migratePersons" class="button searchButton">Migrate Persons</button>
    <br />
    <button v-on:click="migrateVehicles" class="button searchButton">Migrate Vehicles</button>
    <br />
    <button v-on:click="migrateTrades" class="button searchButton">Migrate Trades</button>
    <h3>{{info}}</h3>
    <h3>{{newEntries}}</h3>
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
      persons: [],
      vehicles: [],
      trades: [],
      newEntries: []
    };
  },

  mounted() {
    axios
      .get(`https://localhost:5000/persons`, {
        httpsAgent
      })
      .then(
        result => {
          this.persons = result.data;          
        },
        error => {
          this.info = error;
        }
      );
      axios
      .get(`https://localhost:5000/vehicles`, {
        httpsAgent
      })
      .then(
        result => {
          this.vehicles = result.data;          
        },
        error => {
          this.info = error;
        }
      );
      axios
      .get(`https://localhost:5000/trades`, {
        httpsAgent
      })
      .then(
        result => {
          this.trades = result.data;          
        },
        error => {
          this.info = error;
        }
      );
  },
  methods: {
    migratePersons: async function() {
      this.info = "migrating ...";
      await axios
        .post(
          `https://localhost:5000/manyNewPersonsMongo`,
          this.persons,
          {
            httpAgent: httpsAgent,
            headers: {
              "Content-Type": "application/json"
            }
          }
        )
        .then(() => {
          this.info = "Migrate successfully!";
          //this.newEntries = result.data;
        })
        .catch(e => {
          this.info = e;
        });
    },
    migrateVehicles: async function() {
      this.info = "migrating ...";
      await axios
        .post(
          `https://localhost:5000/manyNewVehiclesMongo`,
          this.vehicles,
          {
            httpAgent: httpsAgent,
            headers: {
              "Content-Type": "application/json"
            }
          }
        )
        .then(() => {
          this.info = "Migrate successfully!";
          //this.newEntries = result.data;
        })
        .catch(e => {
          this.info = e;
        });
    },
    migrateTrades: async function() {
      this.info = "migrating ...";
      await axios
        .post(
          `https://localhost:5000/manyNewTradesMongo`,
          this.trades,
          {
            httpAgent: httpsAgent,
            headers: {
              "Content-Type": "application/json"
            }
          }
        )
        .then(() => {
          this.info = "Migrate successfully!";
          //this.newEntries = result.data;
        })
        .catch(e => {
          this.info = e;
        });
    }
  }
};
</script>
