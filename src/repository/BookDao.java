package repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Topic;

public class BookDao {
    private String query;
    private DbConnection dbConnection = new DbConnection();

    public List<Book> getAll(){
        List<Book> books = new ArrayList<>();
        
        try {
                Connection con = dbConnection.connection();
                query = "select * from books;";
                Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery(query);

                while (result.next()) {
                    int id = result.getInt("id");
                    String bookName = result.getString("bookname");
                    int pageNumber = result.getInt("pagenumber");
                    Topic topic = result.getObject("topic", Topic.class);
                    Date releaseDate = result.getDate("releaseDate");
                    String author = result.getString("authorid");
                
                    Book book  = new Book(id, bookName, pageNumber, topic, releaseDate, author);

                    books.add(book);
                }
                
                

            } catch (Exception e) {
                e.printStackTrace();
            }
                    return books;
        }
}
