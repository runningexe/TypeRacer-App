package application;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by RunningEXE on 3/1/2017.
 */
public class SqliteConnection {
    public static Connection Connector() {
        try{
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\RunningEXE\\Desktop\\SQLite Databases\\typeracerDB.sqlite");
            return conn;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
