package com.moshiur457.tutorial.model;


import javax.persistence.*;

@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @Column
    private String title ;
    @Column
    private String author ;
    @Column
    private String body ;

    public Tutorial(){}

    public Tutorial(String title,String author,String body){
        this.title = title ;
        this.author = author;
        this.body = body;
    }

    public int getId(){
        return id ;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getBody(){
        return body;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
