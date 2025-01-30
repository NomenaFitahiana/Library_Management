package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DbConnection;
import entity.Book;
import entity.Topic;



public class BookCrudOperations implements CrudOperationInterface<Book, Integer>{
    private final DbConnection dbConnection = new DbConnection();
    private String query;

    @Override
    public List<Book> getAll(int size){
        List<Book> books = new ArrayList<>();
        query = "select * from books limit ?;";

       try (Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, size);
                ResultSet result = statement.executeQuery();

           while (result.next()) {
                Book book = new Book();
                book.setId(result.getInt("id"));
                book.setBookName(result.getString("bookname"));
                book.setPageNumber(result.getInt("pagenumbers"));
                book.setReleaseDate(result.getDate("releasedate"));
                book.setAuthor(result.getString("authorid"));
                Topic topic = Topic.valueOf(result.getString("topic").toUpperCase());
                book.setTopic(topic);

                books.add(book);
           }
           return books;

       }catch (SQLException e){
        throw new RuntimeException(e);
       }
    }

    @Override
    public Book findById (Integer id){
        Book book = new Book();
        query = "select * from books where id = ?;";

         try (Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query) ){
                statement.setInt(1, id);

                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    book.setId(result.getInt("id"));
                    book.setBookName(result.getString("bookname"));
                    book.setPageNumber(result.getInt("pagenumbers"));
                    Topic topic = Topic.valueOf(result.getString("topic"));
                    book.setTopic(topic);
                    book.setReleaseDate(result.getDate("releasedate"));
                    book.setAuthor(result.getString("authorid"));
                }else {
                    System.out.println("Book not found !");
                }

                return book;
         } catch(SQLException e){
            throw new RuntimeException(e);
         }
    }

    @Override
    public void deleteById(Integer id){
        query = "delete from books where id = ?;";

        if (id == null) {
            System.out.println("Id couldn' be null");
            return;
        }

       
            try (Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                int result = statement.executeUpdate();

                if (result > 0) {
                    System.out.println("Book deleted !");
                }else System.out.println("Failed to delete the book with id: " + id);

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        
      
    }
}
