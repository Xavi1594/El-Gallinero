<script setup>
import Pagination from '../components/paginationComponent.vue';
import { onBeforeMount, ref, computed, inject } from "vue";
import GlobalApiRepository from '../assets/ApiRepository/GlobalApiRepository';
import { ArticleStore } from '../stores/ArticleStore';
import router from "../router/index";

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
  <main>
    <div class="card mb-3" v-for="article in articlesToShow" :key="article.id" :member="article">

      <div class="gap-3 col-md-9">
        <div class="text-name">
          <p class="font-name">
            <b>{{ article.title }}</b>
          </p>
          <p class="font-italic">{{ article.content }}</p>
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
</template>
<style lang="scss" scoped>
@import ".././assets/sass/variables";
@import ".././assets/sass/global";

.row {
  width: 90%;
  margin: auto;
  margin-top: 5vw;
}

img {
  aspect-ratio: 16/9;
  object-fit: cover;
}

.btn {
  margin: 0.3em;
  width: 5.4em;
}

.card-body {
  display: flex;
  justify-content: end;
  align-items: flex-end;
}

.col-md-1 {
  display: flex;
  justify-content: center;
}

.gap-3 {
  display: flex;
  padding: 0.7rem;
  background-color: $background;
}

@media (max-width: 767px) {
  img {
    width: 90%;
    margin-top: 5vw;
    aspect-ratio: 16/9;
    object-fit: cover;
  }

  .btnsUser {
    display: flex;
    justify-content: space-around;
    // width: 100%;
    // justify-content: center;
  }

  .font-date {
    font-size: 1rem;
  }

  .gap-3 {
    display: block;
    width: 90%;
    margin: auto;
    margin-top: 1rem;
  }

  .card-body {
    display: flex;
    justify-content: center;
    margin-top: 0.7rem;
  }
}
</style>
