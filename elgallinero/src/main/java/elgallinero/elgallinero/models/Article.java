package elgallinero.elgallinero.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {

    public Article() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String content;
    private java.time.LocalDate dateevent;
    private String image = "https://www.fcbarcelona.com/photo-resources/2020/04/27/57da04df-c7d0-428f-b95c-79f1d2b56941/5.jpg?width=1200&height=750";

   

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public java.time.LocalDate getDateevent() {
        return dateevent;
    }

    public void setDateevent(java.time.LocalDate dateevent) {
        this.dateevent = dateevent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
