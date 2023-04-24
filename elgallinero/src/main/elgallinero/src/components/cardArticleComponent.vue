<script setup>
import { defineProps } from 'vue';
import router from '../router';
import { RouterLink } from 'vue-router';



const props = defineProps({
  item: { type: Object },
  defaultImage: { type: String, default: 'https://www.fcbarcelona.com/photo-resources/2020/04/27/57da04df-c7d0-428f-b95c-79f1d2b56941/5.jpg?width=1200&height=750' }
});


</script>
<template>
  <div class="card ">
  <div class="row g-0">
    <div class="col-md-6">
      <img class="img-rounded img-fluid" v-if="item && item.imageArticle" :src="item.imageArticle">
      <img class="img-rounded img-fluid" v-else :src="defaultImage">
    </div>
    <div class="col-md-6 ">
      <div class="card-body m-2">
        <span>{{ item.dateevent }}</span>
        <h5 class="card-title">{{ item && item.title }}</h5>
        <p class="card-text">{{ item && item.content }}</p>
        <router-link :to="{ name: 'articuloindividual', params: { id: item.id } }">
          <button>Leer más</button>
        </router-link>
      </div>
    </div>
  </div>
</div>
</template>
<style scoped lang="scss">
@import "../.././src/assets/sass/variables";
@import "../.././src/assets/sass/global.scss";
card {
    width: 100%;
    padding-top: 20px;
    margin-bottom: 40px;
    .col-md-6 {
      padding: 0 25px 0 40px;
      img {
        width: 100%;
        height: auto;
        margin-bottom: 20px;
      }
    }
    .card-body {
      margin-left: 20px;
      h5.card-title {
        font-family: $font-text;
        color: $text-color;
        font-size: 1.5rem;
        margin-bottom: 20px;
      }
      p.card-text {
        color: $text-color;
        font-size: 1.2rem;
        margin-bottom: 20px;
      }
      span {
        color: $text-color;
        font-size: 1.1rem;
        margin-bottom: 20px;
      }
    }
  }
button {
  padding: 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  position: absolute;
  bottom: 20px;
  right: 20px;
  transition: all 0.2s ease-in-out;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
}

button:hover {
  background-color: #fff;
  color: #333;
}
</style>
