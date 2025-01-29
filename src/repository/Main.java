package repository;
import dao.BookDao;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BookDao book = new BookDao();
    
     //  System.out.println(book.getAll());

     System.out.println(book.findById(13));

       
    }
}
