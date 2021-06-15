package com.muggedbits.chronicler.chronicler.posts;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    @Column
    private LocalDate date;

    @Column
    private int mood;

    @Column
    private String content;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post() {

    }

    public Post(String title, LocalDate date, int mood, String content) {
        this.title = title;
        this.date = date;
        this.mood = mood;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", mood=" + mood +
                ", content='" + content + '\'' +
                '}';
    }
}
