<template>
  <div id="form">
    <h1 align="center">Trade Details</h1>
    <p>
      TradeId:
      <b>{{id}}</b>
    </p>
    <p>
      Seller:
      <b>{{seller}}</b>
    </p>
    <p>
      Seller address:
      <b>{{sellerAddress}}</b>
    </p>
    <p>
      Buyer:
      <b>{{buyer}}</b>
    </p>
    <p>
      Buyer address:
      <b>{{buyerAddress}}</b>
    </p>
    <p>
      Date of trade:
      <b>{{date}}</b>
    </p>
    <p>
      Vehicle brand:
      <b>{{brand}}</b>
    </p>
    <p>
      Vehicle model:
      <b>{{model}}</b>
    </p>
    <p>
      Vehicle Engine:
      <b>{{engine}}</b>
    </p>
    <p>
      Vehicle Horse Power:
      <b>{{hp}}</b>
    </p>
    <p>
      Vehicle Date of registration:
      <b>{{dateOfRegistration}}</b>
    </p>
    <p>
      Vehicle Color:
      <b>{{color}}</b>
    </p>
    <p>
      Vehicle Price:
      <b>{{price}} EUR</b>
    </p>
    <p />
    <p align="center">
      <button v-on:click="back" class="button searchButton">Back to results</button>
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
    id: Number
  },
  data() {
    return {
      date: "",
      seller: "",
      buyer: "",
      brand: "",
      model: "",
      engine: "",
      hp: "",
      dateOfRegistration: "",
      color: "",
      price: ""
    };
  },

  mounted() {
    axios
      .get(`https://localhost:8081/trade/${this.id}`, {
        httpsAgent
      })
      .then(
        result => {
          this.date = result.data.date;
          this.seller = result.data.vehicle.seller.name;
          this.sellerAddress = result.data.vehicle.seller.address;
          this.buyer = result.data.buyer.name;
          this.buyerAddress = result.data.buyer.address;
          this.brand = result.data.vehicle.brand;
          this.model = result.data.vehicle.model;
          this.engine = result.data.vehicle.engine;
          this.hp = result.data.vehicle.hp;
          this.dateOfRegistration = result.data.vehicle.dateOfRegistration;
          this.color = result.data.vehicle.color;
          this.price = result.data.vehicle.price;
        },
        error => {
          this.info = error;
        }
      );
  },

  methods: {
    back: function() {
      this.$router.go(-1);
    }
  }
};
</script>
