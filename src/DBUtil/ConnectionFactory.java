package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public class ConnectionFactory {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static Connection conn;

    public static Connection getInstance() throws SQLException {
        if (conn == null) {
            String url = "jdbc:mysql://192.168.37.69:3306/db_2003?serverTimezone=GMT%2B8&useEncoding=true&characterEncoding=utf-8";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);

        }

        return conn;
    }
}
