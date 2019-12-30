import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER_NAME = "system";
    private static final String PASSWORD = "root";
    private static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
    private static boolean isDriverLoaded = false;

    static{
        try{
            Class.forName(DRIVER_CLASS_NAME);
            isDriverLoaded = true;
            System.out.println("Driver is loaded");
        } catch (Exception e){
            System.out.println("Driver not loaded" + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        if(isDriverLoaded) {
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        return con;
    }

    public static void closeConnection(Connection con) throws SQLException{
        try{
            con.close();
        } catch (Exception e){
            System.out.println("Connection closing error" + e.getMessage());
        }
    }
}
