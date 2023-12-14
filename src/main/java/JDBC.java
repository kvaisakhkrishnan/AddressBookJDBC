import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    String conectionUrl;
    String user;
    String password;
    Connection connection;
    JDBC(){
        this.conectionUrl = "jdbc:mysql://localhost:3306/AddressBook?useSSL=false";
        this.user = "root";
        this.password = "password";
    }
    public void getConnection() throws SQLException {
        this.connection = DriverManager.getConnection(conectionUrl, user, password);
    }
}
