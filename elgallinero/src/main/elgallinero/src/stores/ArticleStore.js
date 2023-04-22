import { defineStore } from 'pinia';
import { ref } from 'vue';

export const ArticleStore = defineStore('ArticleStore', () => {
  const articleObject = ref([]);

  const addArticle = (article) => {
    articleObject.value.push(article);
  };

  return {
    articleObject,
    addArticle,
  };
});
