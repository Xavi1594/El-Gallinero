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

const articlesCardxPage = 3;
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
      <div id="container-articles" v-if="articlesToShow.length > 0">
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
  color: $text-copyright;
  font-size: 2rem;
}
#container-articles {
  display: flex;
  flex-wrap: wrap;
  padding: 20px;
  background-color: white;
  max-width: 1200px;
  margin: 50px auto;
  
}

@media (max-width: 768px) {
  #container-articles .card {
    flex-direction: column;
    .col-md-6 {
      padding: 0;
      img {
        aspect-ratio: 16/5;
        margin-bottom: 20px;
      }
    }
    .card-body {
      margin-left: 0;
      h5.card-title {
        font-size: 1.2rem;
        margin-bottom: 10px;
      }
      p.card-text {
        font-size: 1rem;
        margin-bottom: 10px;
      }
      span {
        font-size: 1rem;
        margin-bottom: 10px;
      }
    }
  }
}
</style>
