<script setup>
import Pagination from '../components/paginationComponent.vue';
import { onBeforeMount, ref, computed, inject } from "vue";
import GlobalApiRepository from '../assets/ApiRepository/GlobalApiRepository';
import { ArticleStore } from '../stores/ArticleStore';
import router from "../router/index";
import navbarComponent from '../components/navbarComponent.vue';
import footerComponent from '../components/footerComponent.vue';

const articlesItem = ArticleStore();
const repository = new GlobalApiRepository("article");
const api = repository.chooseApi();

async function update(id, articles) {
  articlesItem.articlesObject = articles;
  await router.push({ name: 'adminarticules', params: { id: id } });
}

async function deleteArticle(id) {
  if (confirm("¿Está seguro de que quiere borrar este artículo?")) {
    await deleteThis(id);
  }
}

async function deleteThis(id) {
  const response = await fetch(`http://localhost:8080/api/articles/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });
  if (response.ok) {
    alert("Artículo borrado correctamente.");
    location.reload();
  } else {
    const errorMessage = await response.text();
    alert(`Se ha producido un error al borrar el artículo: ${errorMessage}`);
  }
}

const articlesCardPerPage = 4;
const start = ref(0);
const end = computed(() => Math.min(start.value + articlesCardPerPage, articlesList.value.length));

const articlesList = ref([]);
onBeforeMount(async () => {
  articlesList.value = await api.getAll();
});

const articlesToShow = computed(() => {
  return articlesList.value.slice(start.value, end.value);
});

const next = () => {
  start.value += articlesCardPerPage;
};

const prev = () => {
  start.value = Math.max(start.value - articlesCardPerPage, 0);
};

const page = (position) => {
  start.value = position;
};

</script>

<template>
  <navbarComponent />
  <main class="mt-4">
    <div class="container d-flex justify-content-center">
      <div class="row align-items-center">
        <div class="col-lg-12 mb-2 mx-3" v-for="article in articlesToShow" :key="article.id" :member="article">
          <div class="card h-100">
            <img class="img-fluid img-rounded" src="../assets/img/hector.jpg" alt="">
            <div class="card-body d-flex flex-column justify-content-between">
              <div>
                <h5 class="card-title">{{ article.title }}</h5>
                <p class="card-text">{{ article.content }}</p>
              </div>
              <div class="d-flex justify-content-between align-items-center">
                <p class="card-text"><small class="text-muted">{{ article.dateevent }}</small></p>
                <div>
                  <button type="button" class="btn btn-danger" @click="deleteArticle(article.id)">Borrar</button>
                  <button type="button" class="btn btn-warning ms-1" @click="update(article.id, articlesList)">Modificar</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <Pagination :pageSize="articlesCardPerPage" :start="start" :end="end" :maxLength="articlesList.length" @change="page" @prev="prev" @next="next" />
  </main>
</template>

<style lang="scss" scoped>
  @import ".././assets/sass/variables";
  @import ".././assets/sass/global";
  main{
    width: 90%;
  max-width: none;
  margin: 0, auto;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  }
  .card {
    height: 100%;
    display: flex;
    flex-direction: column;
    border-radius: 0;
    background-color: #feffd7;
  }

  .card-img-top {
    object-fit: cover;
    height: 180px;
  }

  img {
    object-fit: cover;
    width: 10rem;
    justify-content: center;
    align-items: center;
  }

  .card-title {
    font-size: 1.5rem;
    font-weight: bold;
    margin-bottom: 0.5rem;
  }

  .card-text {
    margin: 0%;
  }


.btn-danger,
.btn-warning {
  font-size: 0.9rem;
  padding: 0.4rem 0.6rem;
}
</style>