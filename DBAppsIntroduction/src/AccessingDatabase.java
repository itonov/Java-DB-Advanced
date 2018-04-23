import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AccessingDatabase {
    public static void main(String[] args) throws SQLException, IOException {
        String user = "root";
        String password = "";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", user, password);
        PreparedStatement prstmt = conn.prepareStatement("SELECT * FROM employees WHERE salary > ?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String salary = reader.readLine();
        prstmt.setDouble(1, Double.parseDouble(salary));
        ResultSet rs = prstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }
}
