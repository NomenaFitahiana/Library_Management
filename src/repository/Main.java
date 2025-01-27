package repository;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BookDao book = new BookDao();
    
        System.out.println(book.getAll());
       


    }
}
