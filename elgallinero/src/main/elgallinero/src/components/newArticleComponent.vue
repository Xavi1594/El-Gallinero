<script setup>
import { ArticleStore } from ".././stores/ArticleStore";

const articleStore = ArticleStore();

let articlesAdd = {
    title: '',
    content: '',
    dateevent: '',
    image: 'https://www.fcbarcelona.com/photo-resources/2020/04/27/57da04df-c7d0-428f-b95c-79f1d2b56941/5.jpg?width=1200&height=750',
};


async function save() {
    if (articlesAdd.title === '') {
        alert('Debes añadir un título');
        return;
    }

    if (articlesAdd.dateevent === '') {
        alert('Debes añadir una fecha válida');
        return;
    }

    if (articlesAdd.content === '') {
        alert('Tu artículo no tiene contenido');
        return;
    }



    const payload = JSON.stringify(articlesAdd);
    const url = 'http://localhost:8080/api/articles';
    const response = await fetch(url, {
        method: 'POST',
        body: payload,
        headers: {
            'Content-type': 'application/json',
            Accept: 'application/json',
        },
    });

    const data = await response.json();

    if (data.title != '') {
        articleStore.addArticle(data);
        alert('Articulo añadido correctamente');
        router.push('/articulos' + data.id);
        console.log(articleStore.articleObject);
    } else {
        alert('Se ha producido un error');
    }
}
</script>
<template>
  
    <form>
      <div class="container mb-1">
        <div class="row">
          <div class="col-md-8 mx-auto">
            <h2 class="mb-4 mt-2 text-center">Añadir un artículo</h2>
            <div class="mb-3">
              <label for="input-title" class="form-label">Título</label>
              <input v-model="articlesAdd.title" type="text" id="input-title" class="form-control" placeholder="Título del artículo">
            </div>
            <div class="mb-3">
              <label for="input-date" class="form-label">Fecha artículo</label>
              <input v-model="articlesAdd.dateevent" type="date" id="input-date" class="form-control" placeholder="fecha del artículo">
            </div>
            <div class="mb-3">
              <label for="textarea-content" class="form-label">Contenido</label>
              <textarea id="textarea-content" v-model="articlesAdd.content" class="form-control" placeholder="Escribe aquí" rows="10"></textarea>
            </div>
            <div class="d-flex justify-content-between">
              <button @click.prevent="save" type="submit" class="btn btn-primary px-5">
                Enviar
              </button>
              <button type="reset" class="btn btn-warning px-5">
                Borrar
              </button>
            </div>
          </div>
        </div>
      </div>
    </form>

  </template>
 <style lang="scss" scoped>
 @import ".././assets/sass/variables";
 h2{
  color: $text-copyright;
 }
 form {
   background-color: $background;
   color: #fff; 
 }


 input,
 textarea,
 select {
   background-color: #fff; 
   color: #181733; 
   border: none;
   border-radius: 0.25rem;
   padding: 0.5rem;
 }
</style>
