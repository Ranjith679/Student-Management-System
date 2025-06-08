import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection {

    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String username = "root";
    private static final String password = "Rksql@123";

    public static Connection getConnection() throws Exception{
        Connection con = DriverManager.getConnection(url,username,password);
        return con;
    }
}
