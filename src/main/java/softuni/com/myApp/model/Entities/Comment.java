package softuni.com.myApp.model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "comments")
@Entity
public class Comment extends BaseEntity {

    private int score;
    private String textContent;
    private User author;
    private Homework homework;

    public Comment() {
    }

    @Column(name = "score",nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(name = "text_content", columnDefinition = "TEXT" )
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String name) {
        this.textContent = name;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @ManyToOne
    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }
}
