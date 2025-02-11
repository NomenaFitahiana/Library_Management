package test;

import dao.BookCrudOperations;
import entity.Book;
import entity.Topic;

import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.Assertions;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BookCrudOperationsTest {
    BookCrudOperations subject = new BookCrudOperations();

    @Test
    void read_all_books_ok(){
        Book expectedBook = new Book();
        expectedBook.setId(13);
        expectedBook.setBookName("Dracula");
        expectedBook.setPageNumber(400);
        expectedBook.setReleaseDate(java.sql.Date.valueOf(LocalDate.of(1897, 05, 26)));
        expectedBook.setTopic(Topic.ROMANCE);
        expectedBook.setAuthor("A005");
        
        List<Book> actual = subject.getAll(2, 4);

        assertTrue(actual.contains(expectedBook));
    }

    @Test
    void find_one_by_id_ok(){
        Book expectedBook = new Book();
        expectedBook.setId(13);
        expectedBook.setBookName("Dracula");
        expectedBook.setPageNumber(400);
        expectedBook.setReleaseDate(java.sql.Date.valueOf(LocalDate.of(1897, 05, 26)));
        expectedBook.setTopic(Topic.ROMANCE);
        expectedBook.setAuthor("A005");

        Book actual = subject.findById(13);

        assertEquals(expectedBook, actual);
    }

    @Test
    void filter_by_bookname_or_releasedate_between_intervals(){
        
    }

    
}

