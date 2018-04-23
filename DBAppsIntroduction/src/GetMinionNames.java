import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class GetMinionNames {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villain_id = Integer.parseInt(reader.readLine());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", "root", "");
        PreparedStatement prepMinions = conn.prepareStatement("SELECT v.name, m.name, m.age\n" +
                "\tFROM villains AS v\n" +
                "\tINNER JOIN villains_minions AS vm\n" +
                "\tON v.id = vm.villain_id\n" +
                "\tINNER JOIN minions AS m\n" +
                "\tON vm.minion_id = m.id\n" +
                "\tWHERE v.id = ?;");

        prepMinions.setInt(1, villain_id);
        ResultSet rsMinions = prepMinions.executeQuery();

        PreparedStatement prepVillain = conn.prepareStatement("SELECT v.name \n" +
                "\tFROM villains AS v\n" +
                "\tWHERE v.id = ?;");
        prepVillain.setInt(1, villain_id);
        ResultSet rsVillain = prepVillain.executeQuery();
        if (!rsVillain.next()) {
            System.out.println("No villain with ID " + villain_id + " exists in the database.");
        } else {
            System.out.println("Villain: " + rsVillain.getString(1));
        }

        int counter = 1;

        if (!rsMinions.next()) {
            System.out.println("<no minions>");
        } else {
            while (rsMinions.next()) {
                System.out.println(counter + ". " + rsMinions.getString(2) + " " + rsMinions.getInt(3));
            }
        }
    }
}
