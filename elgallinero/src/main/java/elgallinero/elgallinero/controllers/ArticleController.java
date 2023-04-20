package elgallinero.elgallinero.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import elgallinero.elgallinero.models.Article;
import elgallinero.elgallinero.services.ArticleService;

@RestController
@RequestMapping(path = "/api/articles")
public class ArticleController {
    
    private ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }
    
    @GetMapping("")
    public List<Article> getArticles() {
        return service.getArticles();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Long id) {
        Article article = service.findById(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    
    }
    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody Article newArticle) {
    
    try {
        return ResponseEntity.ok(service.save(newArticle));
    } catch (Exception e) {
        return ResponseEntity.status(500).body("error");
    
    }
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@RequestBody Article newArticle, 
    @PathVariable(value = "id") Long id) {
    
        Article article = service.update(newArticle, id);
        return ResponseEntity.ok().body(article);
    }
    
    @DeleteMapping("/{id}")
    public List <Article> delete(@PathVariable long id) {
        return service.delete(id);
    }
    }



