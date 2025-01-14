import java.sql.Connection;

public class DbConnection {
    private final String URL;
    private final String USER;
    private final String PSW;

    Connection getConnection() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        return null;

    }
}
