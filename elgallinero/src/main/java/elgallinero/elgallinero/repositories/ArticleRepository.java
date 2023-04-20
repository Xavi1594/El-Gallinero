package elgallinero.elgallinero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import elgallinero.elgallinero.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}
