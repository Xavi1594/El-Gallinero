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
  await router.push({ name: 'editarArticulos', params: { id: id } });
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
  <main>
    <div class="card mb-3" v-for="article in articlesToShow" :key="article.id" :member="article">

      <div class="gap-3 col-md-9">
        <div class="text-name">
          <p class="font-name">
            <b>{{ article.title }}</b>
          </p>
          <p class="font-italic">{{ article.content }}</p>
         <img src="../assets/img/pedri-removebg-preview.png" alt="">
        </div>
        <div class="gap-3 col-md-9">
          <div class="text-date">
            <p class="font-date">
              <b>{{ article.dateevent }}</b>
            </p>
          </div>
          <div class="card-body">
            <p class="btnsUser">
              <button type="button" class="btn btn-danger" @click="deleteArticle(article.id)">
                Borrar
              </button>

              <button type="button" class="btn btn-warning" @click="update(article.id, articlesList)">
                Modificar
              </button>
            </p>
          </div>
        </div>
      </div>
    </div>


    <Pagination :pageSize="articlesCardPerPage" :start="start" :end="end" :maxLength="articlesList.length" @change="page"
      @prev="prev" @next="next" />
  </main>
  <footerComponent />
</template>
<style lang="scss" scoped>
@import ".././assets/sass/variables";
@import ".././assets/sass/global";

.row {
  width: 90%;
  margin: auto;
  margin-top: 5vw;
}

.card {
  display: flex;
  padding: 0.7rem;
  background: linear-gradient(135deg, #6caddf 0%, #de4759 100%);

  gap: 1rem;
  align-items: center;
}

.card img {
  aspect-ratio: 16/9;
  object-fit: cover;
  width: 150px;
  height: 150px;
  border-radius: 50%;
}

.card-body {
  display: flex;
  justify-content: flex-end;
  align-items: flex-end;
  gap: 1rem;
}

.card-body button {
  margin: 0.3em;
  width: 5.4em;
}

.col-md-1 {
  display: flex;
  justify-content: center;
}

@media (max-width: 767px) {
  .card img {
    width: 100px;
    height: 100px;
  }

  .card-body {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 0.7rem;
    flex-direction: column;
  }

  .card-body button {
    width: 80%;
  }

  .card .card-text {
    font-size: 0.8rem;
    margin-top: 0.5rem;
    text-align: center;
  }

  .card .card-text b {
    font-size: 1rem;
  }

  .row {
    margin-top: 3rem;
  }
}

</style>
