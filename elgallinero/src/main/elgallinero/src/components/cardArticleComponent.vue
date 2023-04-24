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
        <div class="col-md-6" v-if="item && item.imageArticle">
          <img :src="item.imageArticle">
        </div>
        <div class="col-md-6" v-else>
          <img src="https://www.fcbarcelona.com/photo-resources/2020/04/27/57da04df-c7d0-428f-b95c-79f1d2b56941/5.jpg?width=500&height=500">
        </div>
        <div class="col-md-6">
          <div class="card-body">
            <span>{{ item.dateevent }}</span>
            <h5 class="card-title">{{ item && item.title }}</h5>
            <pre class="card-text">{{ item && item.content }}</pre>
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

* {
// background-image: url(../../../elgallinero/src/assets/img/pxfuel.jpg)
}

</style>
