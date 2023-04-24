<template>
    <div class="card">
      <div class="row g-0">
        <div class="col-md-6">
          <img class="img-rounded img-fluid" v-if="item && item.imageArticle" :src="item.imageArticle">
          <img class="img-rounded img-fluid" v-else :src="defaultImage">
        </div>
        <div class="col-md-6">
          <div class="card-body m-2">
            <span>{{ item.dateevent }}</span>
            <h5 class="card-title">{{ item && item.title }}</h5>
            <p class="card-text">{{ item && item.content }}</p>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { computed, ref } from 'vue';
  import { ArticleStore } from '../stores/ArticleStore';
  
  const defaultImage = 'https://via.placeholder.com/150';
  
  // Variable reactiva que almacenará el artículo seleccionado
  const item = ref(null);
  
  // Recuperar el artículo según el id
  const getArticleById = (id) => {
    // Aquí recuperas el artículo según el id y lo devuelves
    return ArticleStore.getArticleById(id);
  }
  
  // Recuperar el id del artículo desde las props
  const id = props.id;
  
  // Buscar el artículo correspondiente
  if (id) {
    item.value = getArticleById(id);
  }
  
  </script>
  
