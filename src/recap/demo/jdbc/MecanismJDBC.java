package recap.demo.jdbc;

import java.sql.*;

public class MecanismJDBC {

    public static void main(String[] args) {

        final String CO_STRING = "jdbc:mysql://localhost:3308/dbslide?serverTimezone=UTC";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException notFound)
        {
            System.out.println("La classe 'com.mysql.cj.jdbc.Driver' n'a pas été trouvée");
        }

        try(Connection co = DriverManager
                .getConnection(CO_STRING, "root", "")){
            System.out.println("Connexion reussie!");

            String requete;
            Statement statement;
            int nbrLigneModif;


            // Create - INSERT - executeUpdate

            statement = co.createStatement();
            requete = " INSERT INTO section VALUES (1116, 'Pilotes', 6) ";
            nbrLigneModif = statement.executeUpdate( requete );

            System.out.println("Nombre de ligne modifiées par l'insert : " + nbrLigneModif);


            // Read - SELECT - executeQuery

            statement = co.createStatement();
            requete = "SELECT * FROM professor WHERE professor_wage >= 2000;";
            ResultSet rs = statement.executeQuery( requete );

            while( rs.next() ){
                int id = rs.getInt("professor_id");
                String name = rs.getString("professor_name");
                int wage = rs.getInt("professor_wage");

                System.out.println( id + " - " + name + " - " + wage);
            }

            // Update - UPDATE - executeUpdate

            statement = co.createStatement();
            requete = "UPDATE section SET section_name = 'pilots' WHERE section_id = 1111";
            nbrLigneModif = statement.executeUpdate( requete );

            System.out.println("Nombre de ligne modifiées par l'insert : " + nbrLigneModif);

            // Delete - DELETE - executeUpdate

            statement = co.createStatement();
            requete = "DELETE FROM section WHERE section_name LIKE 'pilo%'";
            nbrLigneModif = statement.executeUpdate( requete);

            System.out.println("Nombre de ligne modifiées par l'insert : " + nbrLigneModif);
        }
        catch (SQLException e)
        {
            System.out.println("exception sql:" + e.getMessage());
        }
        System.out.println("Fermeture de la connexion.");

    }
}
