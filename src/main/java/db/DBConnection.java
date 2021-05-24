package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection = null;
    private Connection connection = null;

    public DBConnection() throws SQLException{
        String user = "admin";
        String password = "admin";
        String host = "80.34.34.150";
        String port = "33068";
        String database = "BaseDeExamen";

        connection = DriverManager.getConnection("jdbc:mysql://"+ host +":"+port+"/"+database+"?"+"user="+user+"&password="+password,user,password);
    }
   public static  Connection getIstance() throws SQLException{
        if (dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection.connection;
   }
}
