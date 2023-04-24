<template>
  <div>
    <h3>{{ article.title }}</h3>
    <p>{{ article.content }}</p>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import GlobalApiRepository from '../assets/ApiRepository/GlobalApiRepository';
import { onBeforeMount } from 'vue';
import { useRoute } from 'vue-router';

const repository = new GlobalApiRepository( 'article' );
const api = repository.chooseApi('');


const article = ref(null);

onBeforeMount(async () => {
  const route = useRoute();
  const articleId = route.params.id;
  article.value = await api.getById(articleId);
});

</script>

<style>
/* Estilos para el componente aquí */
</style>
