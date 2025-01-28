package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DbConnection;
import entity.Book;



public class BookDao implements CrudOperationInterface<Book>{
    private String query;
    private final DbConnection dbConnection = new DbConnection();

    public void getAll(){
       try (Connection connection = dbConnection.getConnection()){
            if (connection != null) {
                System.out.println("Connected !");
            }else{
                System.out.println("failed !");
            }
       }catch (SQLException e){
        throw new RuntimeException(e);
       }
    }
}
