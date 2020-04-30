package lt.bit.java2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DemoEmployees {

    /*
        SELECT * FROM employees LIMIT 10

        1. Gauti 'Connection' - prisjungimo sesija
        2. Gauti 'Statement' - is connection mes turime gauti statement
            kurio pagelba vykdome konkrecius SQL kalbos sakinius
        3. Ir kaip vykdymo rezultata gauname 'ResultSet'
     */
    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            // failas 'application.properties' ieskomas projekto katalogo virsuje,
            // t.y. kataloge is kurio paleidziama programa
            // InputStream is = new FileInputStream("application.properties");

            InputStream is = DemoEmployees.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (
                Connection conn = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                        properties.getProperty("db.user"),
                        properties.getProperty("db.password"));
                Statement statement = conn.createStatement();
        ) {
            /* you use the connection here */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
