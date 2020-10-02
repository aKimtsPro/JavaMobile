package recap.demo.jdbc;

import java.sql.*;

public class ProfessorDAO {

    private final String CO_STRING = "jdbc:mysql://localhost:3308/dbslide?serverTimezone=UTC";

    // Read

    public void getByName(String name){

        try(Connection co = DriverManager.getConnection(CO_STRING, "root", "")){

            String requete = "SELECT * FROM professor WHERE professor_name = ?";
            PreparedStatement statement = co.prepareStatement( requete );

            statement.setString( 1, name );

            ResultSet rs = statement.executeQuery();

            while( rs.next() ){
                System.out.println(rs.getInt("professor_id") + " - " + rs.getString("professor_name"));
            }

        }
        catch(SQLException e)
        {
            System.out.println( e.getMessage() );
        }

    }
}
