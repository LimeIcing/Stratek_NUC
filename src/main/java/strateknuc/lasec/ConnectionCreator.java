package strateknuc.lasec;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionCreator {

    private Connection connection = null;

    public ConnectionCreator()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() throws Exception{

        // connection to webhost
        /*
        return connection = DriverManager.
                getConnection("jdbc:mysql://den1.mysql6.gear.host/stratekdb?user=stratekdb&password=stratekDB123!&useUnicode=true&characterEncoding=UTF-8");
            */

        // connection to localhost
        return connection = DriverManager.
                getConnection("jdbc:mysql://localhost/stratek?user=root&password=1234&useUnicode=true&characterEncoding=UTF-8");


    }

}
