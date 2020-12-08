<style src="../styles/table.css"></style>

<template>
  <div class="home">
    <h1>Reports:</h1>
    <br/> {{results}}
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
      results: []
    };
  },

  mounted() {
    axios.get(`https://localhost:5000/reports`, { httpsAgent }).then(
      result => {
        this.results = result.data;
      },
      error => {
        alert(error);
      }
    );
  },
  methods: {
    see: function(tradeId) {
      this.$router.push({ name: "trade", params: { _id: tradeId } });
    }
  }
};
</script>