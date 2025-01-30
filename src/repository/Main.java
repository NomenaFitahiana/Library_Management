package repository;
import dao.BookCrudOperations;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BookCrudOperations book = new BookCrudOperations();
    
     System.out.println(book.getAll(4));

     //System.out.println(book.findById(1));

    // book.deleteById(1);
       
    }
}
