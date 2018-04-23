import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNamesCasing {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", "root", "");
        PreparedStatement prepTowns = conn.prepareStatement("SELECT t.name\n" +
                "\tFROM towns AS t\n" +
                "\tWHERE t.country = ?;");
        prepTowns.setString(1, country);
        ResultSet rsTowns = prepTowns.executeQuery();
        List<String> towns = new ArrayList<>();

        if (!rsTowns.next()) {
            System.out.println("No town names were affected.");
        } else {
            while (rsTowns.next()) {
                towns.add(rsTowns.getString(1).toUpperCase());
            }

            PreparedStatement updateTowns = conn.prepareStatement("UPDATE towns AS t\n" +
                    "\tSET t.name = UPPER(t.name)\n" +
                    "\tWHERE t.country = ?;");
            updateTowns.setString(1, country);
            updateTowns.executeUpdate();
            updateTowns.close();

            System.out.println(towns.size() + " town names were affected.");
            System.out.println(towns.toString());
        }

        rsTowns.close();
        prepTowns.close();
        conn.close();
    }
}
