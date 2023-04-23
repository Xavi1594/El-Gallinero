<script setup>
import { ArticleStore } from ".././stores/ArticleStore";

const articleStore = ArticleStore();

let articlesAdd = {
    title: '',
    content: '',
    dateevent: '',
    image:
        'https://www.fcbarcelona.com/photo-resources/2020/04/27/57da04df-c7d0-428f-b95c-79f1d2b56941/5.jpg?width=1200&height=750',
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
        <div class="container mt-2">
            <div class="col-12 col-md-8">
                <h2 class="mt-2">Añadir un artículo</h2>
                <label for="title" class="form-label">Título</label>
                <input v-model="articlesAdd.title" type="text" id="input-title" placeholder="Título del artículo">
            </div>

            <div class="col-12 col-md-8">
                <label for="date" class="form-label">Fecha artículo</label>
                <input v-model="articlesAdd.dateevent" type="date" id="input-date" placeholder="fecha del artículo">
            </div>

            <div class="col-12 col-md-8">
                <label for="content" class="form-label">Contenido</label>
                <textarea id="textarea-content" v-model="articlesAdd.content" placeholder="Escribe aquí" rows="4" cols="50"></textarea>
            </div>

            <div class="d-flex w-80 mb-3 mt-3">
                <button @click.prevent="save" type="submit" class="btn btn-success me-2 w-50">
                    Enviar
                </button>
                <button type="reset" class="btn btn-danger w-50">Borrar</button>
            </div>
        </div>
    </form>
</template>
