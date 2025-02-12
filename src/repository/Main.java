package repository;
import java.util.ArrayList;
import java.util.List;

import dao.BookCrudOperations;
import entity.Criteria;
import entity.Order;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BookCrudOperations book = new BookCrudOperations();
    
    // System.out.println(book.getAll( 2,4));

     //System.out.println(book.findById(1));

    // book.deleteById(1);

    Criteria criteria = new Criteria("bookname", "bookname");
    Criteria cr = new Criteria("releasedate", "1888-01-01");

    List<Criteria> table = new  ArrayList<>();
    table.add(criteria);
    table.add(cr);

    Order or = new Order("bookname", "asc");

    //System.out.println(table);

    System.out.println(book.filterByCriteria(table, or));
       
    }
}
