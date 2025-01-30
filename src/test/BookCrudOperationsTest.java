package test;

import dao.BookCrudOperations;
import entity.Book;
import entity.Topic;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BookCrudOperationsTest {
    BookCrudOperations subject = new BookCrudOperations();

    @Test
    void read_all_books_ok(){
        Book expectedBook = new Book();
        expectedBook.setId(8);
        expectedBook.setBookName("Crime and Punishment");
        expectedBook.setPageNumber(430);
        expectedBook.setReleaseDate(java.sql.Date.valueOf(LocalDate.of(1866, 1, 1)));
        expectedBook.setTopic(Topic.ROMANCE);
        expectedBook.setAuthor("A008");
        
       // List<Book> actual = subject.getAll();

        //assertTrue(actual.contains(expectedBook));
    }

    
}

