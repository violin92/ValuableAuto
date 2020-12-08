<template>
  <div>
    <h1>Add new report</h1>

    <input v-model="date" placeholder="enter date of report (yyyy-mm-dd)" />
    <br />
    <input v-model="bodyDefects" placeholder="enter body defects" />
    <br />
    <input v-model="technicalDefects" placeholder="enter technical defects" />
    <br />
    <input v-model="recommendedPrice" placeholder="enter recommended price" />
    <br />
    <br />
    <button v-on:click="publish" class="button searchButton">Add Report</button>
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

  props: {
    vehicleId: {
      type: String,
      default: "Vue!"
    },
    sellerId: {
      type: String,
      default: "Vue!"
    },
    appraiserId: {
      type: String,
      default: "Vue!"
    }
  },

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
          `https://localhost:5000/reports`,
          {
            date: this.date,
            bodyDefects: this.bodyDefects,
            technicalDefects: this.technicalDefects,
            recommendedPrice: this.recommendedPrice,
            vehicleId: this.vehicleId,
            sellerId: this.sellerId,
            appraiserId: this.$parent.userId
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
