import java.sql.*;

public class GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", "root", "");
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT v.name, COUNT(vm.minion_id) AS minions_count " +
                "FROM villains AS v " +
                "INNER JOIN villains_minions AS vm " +
                "ON v.id = vm.villain_id " +
                "GROUP BY v.name " +
                "HAVING minions_count > 3 " +
                "ORDER BY minions_count;");
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getInt(2));
        }

        rs.close();
        preparedStatement.close();
        conn.close();
    }
}
