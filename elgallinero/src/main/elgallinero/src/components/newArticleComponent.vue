<script setup>
import { ArticleStore } from '../../.././src/stores/ArticleStore';

const articleToAdd = articles();

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

  if (articlesAdd.content === '') {
    alert('Tú artículo no tiene contenido');
    return;
  }

  if (articlesAdd.dateevent === '') {
    alert('Debes añadir una fecha válida');
  }

  const payload = JSON.stringify(articlesAdd);
  const url = 'http://localhost:8080/api/articles';
  const response = fetch(url, {
    method: 'POST',
    body: payload,
    headers: {
      'Content-type': 'application/json',
      Accept: 'application/json',
    },
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.title != '') {
        articleToAdd.articleObject = data;
        alert('Articulo añadido correctamente');
        router.push('/articulos' + data.id);
        console.log(articleToAdd.articleObject);
      } else {
        alert('Se ha producido un error');
      }
    });
}
</script>
