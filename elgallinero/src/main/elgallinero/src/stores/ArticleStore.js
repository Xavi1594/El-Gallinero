import { defineStore } from 'pinia';
import { ref } from 'vue';

export const ArticleStore = defineStore('ArticleStore', () => {
  const articles = ref([]);

  const addArticle = (article) => {
    articles.value.push(article);
  };

  const updateArticle = (updatedArticle) => {
    const index = articles.value.findIndex(article => article.id === updatedArticle.id);
    if (index !== -1) {
      articles.value[index] = updatedArticle;
    }
  };
  
  const getArticleById = (id) => {
    return articles.value.find(article => article.id === id);
  }

  return {
    articles,
    addArticle,
    updateArticle,
    getArticleById,
  };
});
  