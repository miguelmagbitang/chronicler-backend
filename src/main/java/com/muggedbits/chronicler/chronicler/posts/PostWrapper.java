package com.muggedbits.chronicler.chronicler.posts;

import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class PostWrapper {

    private String title;

    private String date;

    private int mood;

    private String content;

    public PostWrapper(String title, String date, int mood, String content) {
        this.title = title;
        this.date = date;
        this.mood = mood;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public Post asPost() {
        LocalDate date = LocalDate.parse(this.date);
        return new Post(this.title, date, this.mood, this.content);
    }

    @Override
    public String toString() {
        return "PostWrapper{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", mood=" + mood +
                ", content='" + content + '\'' +
                '}';
    }
}
