import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(reader.readLine());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", "root", "");
        CallableStatement callableStatement = conn.prepareCall("CALL usp_get_older(?);");
        callableStatement.setInt("id", id);
        callableStatement.execute();
        callableStatement.close();
        conn.close();
    }
}
