package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DbConnection;
import entity.Book;
import entity.Criteria;
import entity.Order;
import entity.Topic;



public class BookCrudOperations implements CrudOperationInterface<Book, Integer>{
    private final DbConnection dbConnection = new DbConnection();
    private String query;

    @Override
    public List<Book> getAll(int page, int size){
        List<Book> books = new ArrayList<>();
        int offset = (page - 1) * size;
        query = "select * from books limit ? offset ?;";

        if(page < 1){
            throw new IllegalArgumentException("Page is not valid, it must be greater than 0, actually it's" + page);
        }

       try (Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, page);
                statement.setInt(2, size);
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

    @Override
    public List<Book> filterByCriteria(List<Criteria> criteria, Order order) {
         StringBuilder sql = new StringBuilder("select * from books where 1 = 1 ");
         List<StringBuilder> sqlCondition = new ArrayList<>();
         List<StringBuilder> sqlConditionFilter = new ArrayList<>();
         List<Book> books = new ArrayList<>();

         for(Criteria c : criteria){
              StringBuilder queryAppend = new StringBuilder("");
           if (c.getColumn() != null) {
                if ("bookname".equals(c.getColumn())) {
                  
                    queryAppend.append(c.getColumn()).append(" ilike").append(" '%").append(c.getValue()).append("%' ");
                }else {
                    queryAppend.append(c.getColumn()).append(" > ").append("'").append(c.getValue()).append("'");
                }
           } else sql.append("");

           sqlCondition.add(queryAppend);
         }

        for(StringBuilder s: sqlCondition){
            if (s.length() != 0) {
                sqlConditionFilter.add(s);
            }
        }

        if (sqlConditionFilter.isEmpty()) {
            sql.append("");
        }else if (sqlConditionFilter.size() == 1) {
            sql.append( "and ").append(sqlConditionFilter.get(0));
        } else if (sqlConditionFilter.size() == 2) {
            sql.append(" and ").append(sqlConditionFilter.get(0)).append(" or ").append(sqlConditionFilter.get(1));
        }

        if (order.getColumn() != null) {
            sql.append(" order by ").append(order.getColumn()).append(" ").append(order.getOrder());
        } else sql.append("");
        
        try (Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement()){
        
            ResultSet result = statement.executeQuery(sql.toString());

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
