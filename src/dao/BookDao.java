package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DbConnection;
import entity.Book;
import entity.Topic;



public class BookDao implements CrudOperationInterface<Book>{
    private final DbConnection dbConnection = new DbConnection();
    private String query;

    @Override
    public List<Book> getAll(){
        List<Book> books = new ArrayList<>();

        query = "select * from books;";
       try (Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement()){
           ResultSet result = statement.executeQuery(query);

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

    
}
