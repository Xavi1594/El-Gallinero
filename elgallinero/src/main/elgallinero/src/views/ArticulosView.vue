<script setup>
import navbarComponent from "../components/navbarComponent.vue";
import cardArticleComponent from "../components/cardArticleComponent.vue";
import paginationComponent from "../components/paginationComponent.vue";
import footerComponent from "../components/footerComponent.vue";
import GlobalApiRepository from "../assets/ApiRepository/GlobalApiRepository";
import { onBeforeMount, ref, computed } from "vue";
import {ArticleStore} from "../stores/ArticleStore";


const repository = new GlobalApiRepository("article"); 
const api = repository.chooseApi();

const articlesCardxPage = 4;
const start = ref(0);
const end = computed(() => Math.min(start.value + articlesCardxPage, articlesList.value.length));

let articlesList = ref([]);
onBeforeMount(async () => {
  articlesList.value = await api.getAll();
});

const articlesToShow = computed(() => {
  return articlesList.value.slice(start.value, end.value);
});

const next = () => {
  start.value += articlesCardxPage;
};

const prev = () => {
  start.value = Math.max(start.value - articlesCardxPage, 0);
};

const page = (position) => {
  start.value = position;
};
</script>

<template>
  <navbarComponent />
  <main >
    <div class="mt-5">
      <div class="container" id="headerH3">
        <h3 class="text-center mt-5 mb-3">Últimos artículos</h3>
      </div>
      <div id="container-Articles" v-if="articlesToShow.length > 0">
        <cardArticleComponent v-for="article in articlesToShow" :key="article.id" :item="article" />
      </div>
      <paginationComponent :pageSize="articlesCardxPage" :start="start" :end="end" :maxLength="articlesList.length" @change="page" @prev="prev" @next="next" />
    </div>
    <footerComponent />
  </main>
</template>

<style lang="scss" scoped>
@import ".././assets/sass/variables";
h3 {
  color:$text-copyright;
  font-size: 2rem;
}

    img {
      width: 100%;
      aspect-ratio: 16/5;
      object-fit: cover;
      transition: all 0.4s;
    }
 
</style>
