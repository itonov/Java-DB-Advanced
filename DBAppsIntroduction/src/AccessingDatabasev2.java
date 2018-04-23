import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AccessingDatabasev2 {
    public static void main(String[] args) throws SQLException, IOException {
        String username = "root";
        String password = "";
        String URL = "jdbc:mysql://localhost:3306/diablo";
        Connection connection = DriverManager.getConnection(URL, username, password);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputUsername = reader.readLine();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT u.user_name, u.first_name, u.last_name, COUNT(g.id) AS played_games FROM users AS u " +
                        "INNER JOIN users_games AS ug " +
                        "ON u.id = ug.user_id " +
                        "INNER JOIN games AS g " +
                        "ON ug.game_id = g.id " +
                        "WHERE u.user_name = ? " +
                        "GROUP BY u.user_name, u.first_name, u.last_name ");
        preparedStatement.setString(1, inputUsername);
        ResultSet rs = preparedStatement.executeQuery();

        if (!rs.next()) {
            System.out.println("No such user exists");
        } else {
            System.out.println("User:" + rs.getString("user_name") + "\n" +
                    rs.getString("first_name") + " " + rs.getString("last_name") + " has played " +
                    rs.getInt("played_games") + " games");
        }

        rs.close();
        preparedStatement.close();
        connection.close();
    }
}
