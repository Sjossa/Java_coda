package exercice_J3;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import exercice_J3.bdd.BDD;
// import exercice_J3.tools.Functions;

public class Main {
    public static void main(String[] args) {
        // Functions.combatClavier();

        try (Connection conn = BDD.getConnection()) {
            System.out.println("Connexion réussie !");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS utilisateurs (id INT AUTO_INCREMENT PRIMARY KEY, nom VARCHAR(50))");
            stmt.executeUpdate("INSERT INTO utilisateurs (nom) VALUES ('Johnny')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM utilisateurs");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("nom"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


