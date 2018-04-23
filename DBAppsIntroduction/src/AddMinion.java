import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AddMinion {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] minionTokens = reader.readLine().split(" ");
        String minionName = minionTokens[1];
        int minionAge = Integer.parseInt(minionTokens[2]);
        String minionTown = minionTokens[3];
        String villainName = reader.readLine().split(" ")[1];
        String defaultEvilnessFactor = "evil";

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minionsdb", "root", "");
        PreparedStatement townCheck = conn.prepareStatement("SELECT t.id\n" +
                "\tFROM towns AS t\n" +
                "\tWHERE t.name = ?;");
        townCheck.setString(1, minionTown);
        ResultSet rsTown = townCheck.executeQuery();

        if (!rsTown.next()) {
            PreparedStatement addTown = conn.prepareStatement("INSERT INTO towns (name)\n" +
                    "\tVALUES (?);");
            addTown.setString(1, minionTown);
            addTown.executeUpdate();
            System.out.println("Town " + minionTown + " was added to the database.");
            addTown.close();
        }

        rsTown.close();
        townCheck.close();

        PreparedStatement villainCheck = conn.prepareStatement("SELECT v.id\n" +
                "\tFROM villains AS v\n" +
                "\tWHERE v.name = ?;");
        villainCheck.setString(1, villainName);
        ResultSet rsVillain = villainCheck.executeQuery();

        if (!rsVillain.next()) {
            PreparedStatement addVillain = conn.prepareStatement("INSERT INTO villains (name, evilness_factor)\n" +
                    "\tVALUES (?, ?);");
            addVillain.setString(1, villainName);
            addVillain.setString(2, defaultEvilnessFactor);
            addVillain.executeUpdate();
            System.out.println("Villain " + villainName + " was added to the database.");
            addVillain.close();
        }

        rsVillain.close();

        ResultSet neededVillain = villainCheck.executeQuery();
        neededVillain.next();
        int villainId = neededVillain.getInt(1);
        neededVillain.close();
        villainCheck.close();

        PreparedStatement checkForMinion = conn.prepareStatement("SELECT m.id\n" +
                "\tFROM minions AS m\n" +
                "\tWHERE m.name = ?;");
        checkForMinion.setString(1, minionName);
        ResultSet rsMinion = checkForMinion.executeQuery();

        if (!rsMinion.next()) {
            PreparedStatement addMinion = conn.prepareStatement("INSERT INTO minions (name, age, town)\n" +
                    "\tVALUES (?, ?, ?);");
            addMinion.setString(1, minionName);
            addMinion.setInt(2, minionAge);
            addMinion.setString(3, minionTown);
            addMinion.executeUpdate();
            addMinion.close();
        }

        rsMinion.close();
        ResultSet neededMinion = checkForMinion.executeQuery();
        neededMinion.next();
        int minionId = neededMinion.getInt(1);
        neededMinion.close();
        checkForMinion.close();

        PreparedStatement addMinionToVillain = conn.prepareStatement("INSERT INTO villains_minions (villain_id, minion_id)\n" +
                "\tVALUES (?, ?);");
        addMinionToVillain.setInt(1, villainId);
        addMinionToVillain.setInt(2, minionId);
        boolean addedMinion = addMinionToVillain.executeUpdate() != 0;
        if (addedMinion) {
            System.out.println("Successfully added " + minionName + " to be minion of " + villainName);
        }
        addMinionToVillain.close();
        conn.close();
    }
}
