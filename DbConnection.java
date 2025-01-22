import java.sql.*;

public class DbConnection {
    private final String URL = "jdbc:postgresql://localhost:5432/librarymanagement";
    private final String USER = "nomena";
    private final String PSW = "library";
    private String query = "select * from author;";

    public void connection() throws ClassNotFoundException{
        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USER, PSW);
        ){
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
        
                String author = "";

               for (int i = 1; i <= 3; i++) {
                    author += result.getString(i) + "-";
               }

               System.out.println(author);
            }
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
