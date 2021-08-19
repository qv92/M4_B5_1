package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private Date postDate;
    private String title;
    private String img;
    @Column(columnDefinition = "TEXT")
    private String intro;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Blog() {
    }

    public Blog(String author, Date postDate, String title, String img, String intro, String content) {
        this.author = author;
        this.postDate = postDate;
        this.title = title;
        this.img = img;
        this.intro = intro;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
