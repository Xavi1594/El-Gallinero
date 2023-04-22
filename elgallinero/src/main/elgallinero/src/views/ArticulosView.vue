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

const articlesCardxPage = 8;
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
  <main>
    <div class="mt-5">
      <navbarComponent />
      <div class="container" id="headerH3">
        <h3>Últimos artículos</h3>
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
/* mt-5 {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}
#container-Articles {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  width: 90%;
}
#headerH3 {
  width: 90%;
}
h3 {
  font-weight: bold;
  margin: 0.5em;
}
#color-pag  {
  color: black;
} */
</style>
