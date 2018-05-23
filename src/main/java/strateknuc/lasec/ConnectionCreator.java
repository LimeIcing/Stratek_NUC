package strateknuc.lasec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//AUTHOR: AP
public class ConnectionCreator {

    private Connection connection = null;

    // This constructor makes sure the jdbc driver for preparedStatement is injected and if it isnt, it prints out an
    // error message
    public ConnectionCreator() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // This returns a new connection with the required password and user parameters in a url string it also throws
    // an Exception if the connection fails.
    public Connection getConnection() {
        try {
            // connection to webhost
        /*
        connection = DriverManager.
                getConnection("jdbc:mysql://den1.mysql6.gear.host/stratekdb?user=stratekdb&password=stratekDB123!&useUnicode=true&characterEncoding=UTF-8");
        */

            // connection to localhost; pw=1234
        /*
        connection = DriverManager.
                getConnection("jdbc:mysql://localhost/stratek?user=root&password=1234&useUnicode=true&characterEncoding=UTF-8");


        // connection to localhost; pw=toor
        */
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/stratek?user=root&password=toor&useUnicode=true&characterEncoding=UTF-8");
            //*/

            // connection to localhost; pw=
        /*
        connection = DriverManager.
                getConnection("jdbc:mysql://localhost/stratek?user=root&password=&useUnicode=true&characterEncoding=UTF-8");
        */
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
