package strateknuc.lasec;

import strateknuc.lasec.DevUsers.DevUserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author AP
 */
public class ConnectionCreator {

    private static ConnectionCreator instance = null;
    private Connection connection = null;

    private DevUserInfo devUserInfo = new DevUserInfo();

    /**
     * This constructor makes sure the jdbc driver for preparedStatement is injected and if it isnt, it prints out an
     * error message
     */
    private ConnectionCreator()
    {
        //Exists only to defeat instantiation
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ConnectionCreator getInstance()
    {
        if(instance == null)
        {
            instance = new ConnectionCreator();
        }
        return instance;
    }




    /**
     * returns a new connection with the required password and user parameters in an url string.
     * it throws an Exception if the connection fails.
     * @return the desired connection
     */
    public Connection getConnection() {
        try {
            // connection to webhost
        /*
        connection = DriverManager.
                getConnection("jdbc:mysql://den1.mysql6.gear.host/stratekdb?user=stratekdb&password=stratekDB123!&useUnicode=true&characterEncoding=UTF-8");
        */



            //----can be used with devUserInfo class, just write your own MySQL database username and password in the
            //dbUserName and dbPassword fields.

            //the devUserInfo file should be git ignored
            /*connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/stratek?user="+devUserInfo.getDbUserName()+"&password?"+
                    devUserInfo.getDbPassword()+"&useUnicode=true&characterEncoding=UTF-8");*/

            // connection to localhost
        connection = DriverManager.
                getConnection("jdbc:mysql://localhost/stratek?user=groot&password=iamgroot&useUnicode=true&characterEncoding=UTF-8");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
