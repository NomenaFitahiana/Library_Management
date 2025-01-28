package repository;
import java.sql.*;

import dao.BookDao;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BookDao book = new BookDao();
    
        book.getAll();
       


    }
}
