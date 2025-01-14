package model;

import java.sql.Date;

public class Book {
    private int id;
    private String bookName;
    private int pageNumber;
    private Topic topic;
    private Date releaseDate;
    private Author author;

    public Book(int id, String bookName, int pageNumber, Topic topic, Date releaseDate, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.topic = topic;
        this.releaseDate = releaseDate;
        this.author = author;
    };

    public int getId() {
        return this.id;
    };

    public void setId(int id) {
        this.id = id;
    };

    public String getBookName() {
        return this.bookName;
    };

    public void setBookName(String bookName) {
        this.bookName = bookName;
    };

    public int getPageNumber() {
        return this.pageNumber;
    };

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    };

    public Topic getTopic() {
        return this.topic;
    };

    public void setTopic(Topic topic) {
        this.topic = topic;
    };

    public Date getReleaseDate() {
        return this.releaseDate;
    };

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    };

    public Author getAuthor() {
        return this.author;
    };

    public void setAuthor(Author author) {
        this.author = author;
    };
}
