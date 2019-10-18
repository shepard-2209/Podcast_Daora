// 
// Decompiled by Procyon v0.5.36
// 

package Database;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao
{
    private static final String DB_DRIVER = "serversoft7.database.windows.net";
    private static final String DB_CONNECTION = "jdbc:sqlserver://serversoft7.database.windows.net:1433;database=SevenSoft";
    private static final String DB_USER = "ninja";
    private static final String DB_PASSWORD = "x=Rw4=P_";
    
    static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("serversoft7.database.windows.net");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlserver://serversoft7.database.windows.net:1433;database=SevenSoft", "ninja", "x=Rw4=P_");
            return dbConnection;
        }
        catch (SQLException e2) {
            System.out.println(e2.getMessage());
            return dbConnection;
        }
    }
}
