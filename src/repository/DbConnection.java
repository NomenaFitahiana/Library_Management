package repository;
import java.sql.*;

public class DbConnection {
    private final String URL = "jdbc:postgresql://localhost:5432/librarymanagement";
    private final String USER = "nomena";
    private final String PSW = "library";

    Connection connection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PSW);
        
    }
}
