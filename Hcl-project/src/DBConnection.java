import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "sys as sysdba";
        String password = "1234";
        //fill your code here
        
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
