<style src="../styles/table.css"></style>

<template>
  <div class="home">
    <h1>Trades: </h1>
    <table>
      <thead>
        <tr>
          <th>
            TradeId
            <span class="arrow"></span>
          </th>
          <th>
            VehicleId
            <span class="arrow"></span>
          </th>
          <th>
            SellerId
            <span class="arrow"></span>
          </th>
          <th>
            BuyerId
            <span class="arrow"></span>
          </th>
          <th>
            <span class="arrow"></span>
          </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="trade in results" v-bind:key="trade">
          <td>{{trade.id}}</td>
          <td>{{trade.vehicle.id}}</td>
          <td>{{trade.vehicle.seller.id}}</td>
          <td>{{trade.buyer.id}}</td>
          <td>
            <button v-on:click="see(trade.id)" class="seeButton searchButton">See details</button>
          </td>
        </tr>
      </tbody>
    </table>
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
    axios.get(`https://localhost:8081/trades`, { httpsAgent }).then(
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
      this.$router.push({ name: "trade", params: { id: tradeId } });
    }
  }
};
</script>
