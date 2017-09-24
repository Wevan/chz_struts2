package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Wean on 2017/6/2.
 */
public class JDBCUtil {

    public static Connection getConnection() {

        final String DBDRIVER = "com.mysql.jdbc.Driver";
        final String DBURL = "jdbc:mysql://localhost:3306/ksdb";
        final String DBUSER = "root";
        final String DBPASS = "wean124";
        Connection conn = null;
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
