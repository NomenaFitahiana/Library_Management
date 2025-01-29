package entity;

import java.sql.Date;
import java.util.Objects;

public class Book {
    private int id;
    private String bookName;
    private int pageNumber;
    private Topic topic;
    private Date releaseDate;
    private String author;

    public Book(int id, String bookName, int pageNumber, Topic topic, Date releaseDate, String author) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.topic = topic;
        this.releaseDate = releaseDate;
        this.author = author;
    };

    public Book (){};

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

    public String getAuthor() {
        return this.author;
    };

    public void setAuthor(String author) {
        this.author = author;
    };

    @Override
    public String toString() {
        return "Book { id = " + id +
                        ", bookName = " + bookName +
                        ", pageNumber = " + pageNumber +
                        ", topic = " + topic +
                        ", releaseDate = " + releaseDate +
                        ", author = " + author + "}";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Objects.equals(id, book.id) && Objects.equals(bookName, book.bookName) && Objects.equals(pageNumber, book.pageNumber) && Objects.equals(topic, book.topic) && Objects.equals(releaseDate, book.releaseDate) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, bookName, pageNumber, topic, releaseDate, author);
    }

}
