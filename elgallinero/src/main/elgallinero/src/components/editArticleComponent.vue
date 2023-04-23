<script setup>
import { computed } from 'vue';
import { ArticleStore } from '../stores/ArticleStore';

const articleToModify = ArticleStore();
const articleData = computed(() => {
  return articleToModify.articleObject;
});

const articleEdit = {
  title: articleToModify.articleObject.title,
  dateevent: articleToModify.articleObject.dateevent,
  content: articleToModify.articleObject.content,
  id: articleToModify.articleObject.id,
};
async function update(id) {
  if (articleEdit.title.trim() === '') {
    alert('Se necesita añadir un nombre');
    return;
  }
  if (articleEdit.dateevent.trim() === '') {
    alert('Se necesita añadir una fecha para el artículo');
    return;
  }
  if (articleEdit.content.trim() === '') {
    alert('No has añadido contenido');
    return;
  }

  const payload = JSON.stringify(articleEdit);
  const url = `http://localhost:8080/api/articles/${id}`;
  const response = await fetch(url, {
    method: 'PUT',
    body: payload,
    headers: {
      'Content-type': 'application/json',
      Accept: 'application/json',
    },
  });
  const data = await response.json();
  if (data.title) {
    articleToModify.articleObject = data;
    articleEdit.title = data.title;
    articleEdit.dateevent = data.dateevent;
    articleEdit.content = data.content;
    alert('Artículo actualizado correctamente');
  } else {
    alert('Ha habido un error');
  }
}

</script>
<template>
  <form>
    <div class="container mt-2">
      <div class="col-12 col-md-8">
        <h2 class="mt-2">Modificar sección {{ articleData.title }}</h2>
        <div class="mb-3">
          <label for="title" class="form-label">Título</label>
          <input v-model="articleEdit.title" id="edit-input-title" class="form-control" type="text" placeholder="Título" />
        </div>
        <div class="mb-3">
          <div class="col-12 col-md-8">
            <label for="date" class="form-label">Fecha artículo</label>
            <input v-model="articleEdit.dateevent" type="date" id="edit-input-date" placeholder="fecha del artículo" />
          </div>
          <div class="col-12 col-md-8">
            <label for="content" class="form-label">Contenido</label>
            <textarea id="edit-textarea-content" v-model="articleEdit.content" placeholder="Escribe aquí" rows="6" cols="350"></textarea>
          </div>
          <div class="d-flex mb-3 mt-3">
            <button @click.prevent="update(articleData.id)" type="button" class="btn btn-success me-2">
              Modificar
            </button>
            <button type="reset" class="btn btn-danger">Borrar</button>
          </div>
        </div>
      </div>
    </div>
  </form>
</template>

<style lang="scss" scoped>
@import ".././assets/sass/variables";
.container {
  width: 80%;
  max-width: none;
  margin: 0 auto;
  display: flex;
  justify-content: space-around;
  align-items: center;
  flex-direction: column;
  background-color: $background-component;
  height: 100%;
}

.form-control {
  width: 100%;
  border-radius: 10px;
}

.label {
  font-family: $font-text;
}

input, textarea{
  width: 100%;
  background-color: #ffffff;
}

.btn {
  width: 100%;
}

textarea {
  height: 250px;
}

@media (min-width: 768px) {
  .w-10 {
    width: 10%;
  }
}

</style>