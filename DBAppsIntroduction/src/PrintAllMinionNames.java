import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {
        List<String> minionNames = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", "root", "");
        PreparedStatement prep = conn.prepareStatement("SELECT m.name\n" +
                "\tFROM minions AS m;");

        ResultSet rs = prep.executeQuery();

        while (rs.next()) {
            minionNames.add(rs.getString("name"));
        }

        rs.close();
        prep.close();
        conn.close();

        for (int i = 0; i < minionNames.size() / 2; i++) {
            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(minionNames.size() - i - 1));
        }
    }
}
