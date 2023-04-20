package elgallinero.elgallinero.services;

import java.util.List;


import org.springframework.stereotype.Service;

import elgallinero.elgallinero.models.Article;
import elgallinero.elgallinero.repositories.ArticleRepository;

@Service
public class ArticleService {
    
        private ArticleRepository repository;
    
        public ArticleService(ArticleRepository repository) {
            this.repository = repository;
        }
    
        public List<Article> getArticles() {
            return repository.findAll();
        }
    
        public Article findById(Long id) {
            return repository.findById(id).orElse(null);
        }
    
        public Article save(Article article) {
            Article articleSaved = repository.save(article);
            return articleSaved ;
        }
    
        public Article update(Article article, Long id) {
          Article articleCurrent = repository.findById(id).orElseThrow();
    
          articleCurrent.setId(article.getId());
    
        
            return repository.save(articleCurrent);
        }
    
        public List<Article> delete(Long id) {
    
            Article articleToDelete = repository.findById(id).orElse(null);
            repository.delete(articleToDelete);
            return repository.findAll();
        }
    }



