package test;

import dao.BookCrudOperations;
import entity.Book;
import entity.Criteria;
import entity.Order;
import entity.Topic;

import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.Assertions;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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
    void filter_by_bookname_or_releasedate_or_both(){
        
        List<Book> expectedBook = new ArrayList<>();
        Book expectedBook4 = new Book (10, "1984", 328, Topic.COMEDY, Date.valueOf("1949-06-08"), "A002");
        Book expectedBook2 = new Book (13, "Dracula", 400, Topic.ROMANCE, Date.valueOf("1897-05-26"), "A005");
        Book expectedBook3 = new Book (11, "Harry Potter", 500, Topic.OTHER, Date.valueOf("1997-06-26"), "A003");
        Book expectedBook1 = new Book(9, "Le Petit Prince", 120, Topic.ROMANCE, Date.valueOf("1943-04-06"), "A001");
        
      
       

        Order or = new Order("bookname", "asc");

        Criteria criteria = new Criteria("bookname", "bookname");
        Criteria cr = new Criteria("releasedate", "1888-01-01");

        List<Criteria> table = new  ArrayList<>();
        table.add(criteria);
        table.add(cr);

        expectedBook.add(expectedBook4);
        expectedBook.add(expectedBook2);
        expectedBook.add(expectedBook3);
        expectedBook.add(expectedBook1);

        List<Book> actual = subject.filterByCriteria(table, or);

        assertEquals(expectedBook, actual);

       
        
    }


   
    
}

