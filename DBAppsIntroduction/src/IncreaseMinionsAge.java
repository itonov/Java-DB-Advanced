import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IncreaseMinionsAge {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ids = Arrays.stream(reader.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", "root", "");
        PreparedStatement increaseAge = conn.prepareStatement("UPDATE minions AS m\n" +
                "\tSET m.age = m.age + 1\n" +
                "\tWHERE m.id = ?;");

        PreparedStatement changeNames = conn.prepareStatement("UPDATE minions AS m\n" +
                "\tSET m.name = CONCAT(UPPER(LEFT(m.name, 1)), SUBSTR(m.name, 2))\n" +
                "\tWHERE m.id = ?;");

        for (int id : ids) {
            increaseAge.setInt(1, id);
            increaseAge.executeUpdate();

            changeNames.setInt(1, id);
            changeNames.executeUpdate();
        }

        increaseAge.close();
        changeNames.close();

        Statement getAllMinions = conn.createStatement();
        String query = "SELECT m.name, m.age\n" +
                "\tFROM minions AS m;";
        ResultSet rs = getAllMinions.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getInt("age"));
        }
    }
}
