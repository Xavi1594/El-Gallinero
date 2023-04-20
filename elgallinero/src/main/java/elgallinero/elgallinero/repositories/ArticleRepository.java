package elgallinero.elgallinero.repositories;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository <Long, Id> {
    
}
