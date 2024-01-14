package DBlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconnection {

    private final String URL = "jdbc:mysql://localhost:3306/CareCare";
    private final String UName = "root";
    private final String Password = "";
    private static dbconnection instance;
    private Connection con;

    private dbconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, UName, Password);
            System.out.println("Database Connection Success");
        } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace();
        System.out.println("Error in database connection: " + ex.getMessage());
    }

}

    public static dbconnection getSingleInstance() {
        try {
            if (instance == null || instance.con.isClosed()) {
                instance = new dbconnection();
            }
            return instance;
        } catch (SQLException ex) {
            System.out.println("Database Connection Error: " + ex.getMessage());
            ex.printStackTrace(); // Print the stack trace for debugging
            return null;
        }
    }

    public Connection getConnection() {
        return con;
    }

    public boolean ExecuteQuery(String sqlQ) {
        try {
            Statement st = con.createStatement();
            int result = st.executeUpdate(sqlQ);
            return result > 0;
        } catch (SQLException ex) {
            System.out.println("SQL Error " + ex.getMessage());
            return false;
        }
    }


}

