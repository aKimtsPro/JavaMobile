package nouveau.jdbc.exo;

import nouveau.jdbc.exo.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final String CO_STRING = "jdbc:mysql://localhost:3308/dbslide?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PSWD = "";

    public StudentDAO() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver not found");
        }

    }

    // READ

    public Student getById(int id){

        try(Connection co = DriverManager.getConnection(CO_STRING, USERNAME, PSWD)){

            String requete = "SELECT * FROM student WHERE student_id = ?";
            PreparedStatement ps = co.prepareStatement( requete );

            ps.setInt( 1, id );

            ResultSet rs = ps.executeQuery();

            Student resultat = null;

            if( rs.next() )
            {
                resultat = new Student();
                resultat.setStudent_id( rs.getInt("student_id") );
                resultat.setFirst_name( rs.getString("first_name") );
                resultat.setLast_name( rs.getString("last_name") );
                resultat.setBirthdate( rs.getDate("birth_date") );
                resultat.setLogin( rs.getString("login") );
                resultat.setSection_id( rs.getInt("section_id") );
                resultat.setYear_result( rs.getInt("year_result") );
                resultat.setCourse_id( rs.getString("course_id") );
            }
            return resultat;

        }
        catch (SQLException e){
            System.out.println("SQLException : " + e.getMessage());
            return null;
        }

    }

    public List<Student> getAll(){

        List<Student> rsltList = new ArrayList<>();

        try(Connection co = DriverManager.getConnection(CO_STRING, USERNAME, PSWD)){

            String requete = "SELECT * FROM student";
            PreparedStatement ps = co.prepareStatement( requete );

            ResultSet rs = ps.executeQuery();

            while( rs.next() ){

                Student resultat = new Student();
                resultat.setStudent_id( rs.getInt("student_id") );
                resultat.setFirst_name( rs.getString("first_name") );
                resultat.setLast_name( rs.getString("last_name") );
                resultat.setBirthdate( rs.getDate("birth_date") );
                resultat.setLogin( rs.getString("login") );
                resultat.setSection_id( rs.getInt("section_id") );
                resultat.setYear_result( rs.getInt("year_result") );
                resultat.setCourse_id( rs.getString("course_id") );

                rsltList.add( resultat );
            }

        }
        catch (SQLException e){
            System.out.println( "SQLException : " + e.getMessage() );
        }

        return rsltList;

    }

    // CREATE

    public boolean insert(Student toInsert){

        boolean rslt = false;

        try(Connection co = DriverManager.getConnection(CO_STRING, USERNAME, PSWD)) {

            String requete = "INSERT INTO student VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement ps = co.prepareStatement( requete );

            ps.setInt( 1, toInsert.getStudent_id() );
            ps.setString( 2 , toInsert.getFirst_name() );
            ps.setString( 3 , toInsert.getLast_name() );
            ps.setDate(4, (Date) toInsert.getBirthdate());
            ps.setString( 5, toInsert.getLogin() );
            ps.setInt( 6, toInsert.getSection_id());
            ps.setInt( 7, toInsert.getYear_result());
            ps.setString( 8, toInsert.getCourse_id());

            if( ps.executeUpdate() == 1 )
                rslt = true;
        }
        catch (SQLException e)
        {
            System.out.println("SQLException : " + e.getMessage() );
        }

        return rslt;
    }

    // UPDATE

    public boolean update(Student toUpdate){

        boolean rslt = false;

        try(Connection co = DriverManager.getConnection(CO_STRING, USERNAME, PSWD)) {

            String requete = "UPDATE student SET "+
                    " first_name = ?, " +
                    " last_name = ?, " +
                    " birth_date = ?, " +
                    " login = ?, " +
                    " section_id = ?, " +
                    " year_result = ?, " +
                    " course_id = ? " +
                    " WHERE student_id = ?";
            PreparedStatement ps = co.prepareStatement( requete );

            ps.setString( 1 , toUpdate.getFirst_name() );
            ps.setString( 2 , toUpdate.getLast_name() );
            ps.setDate(3, (Date) toUpdate.getBirthdate());
            ps.setString( 4, toUpdate.getLogin() );
            ps.setInt( 5, toUpdate.getSection_id());
            ps.setInt( 6, toUpdate.getYear_result());
            ps.setString( 7, toUpdate.getCourse_id());
            ps.setInt( 8, toUpdate.getStudent_id() );

            if( ps.executeUpdate() == 1 )
                rslt = true;
        }
        catch (SQLException e)
        {
            System.out.println("SQLException : " + e.getMessage() );
        }

        return rslt;
    }

    // DELETE

    public boolean delete(int id){

        boolean rslt = false;

        try(Connection co = DriverManager.getConnection(CO_STRING, USERNAME, PSWD)) {

            String requete = "DELETE FROM student WHERE student_id = ?";
            PreparedStatement ps = co.prepareStatement(requete);
            ps.setInt(1, id);

            if(  ps.executeUpdate() == 1 )
                rslt = true;

        }
        catch (SQLException e){
            System.out.println("SQLException : " + e.getMessage());
        }

        return rslt;
    }

    // OTHER

    public List<String> getSectionNameWithStudent(){

        List<String> sectionNames = new ArrayList<>();

        try( Connection co = DriverManager.getConnection(CO_STRING, USERNAME, PSWD)){

            String requete = " SELECT DISTINCT section_name " +
                    "FROM student s " +
                    "INNER JOIN section sect "+
                    "ON s.section_id = sect.section_id ";
            PreparedStatement ps = co.prepareStatement( requete );


            ResultSet rs = ps.executeQuery();

            while( rs.next() )
            {
                sectionNames.add( rs.getString("section_name") );
            }


        }
        catch ( SQLException e ) {
            System.out.println( "SQLException : " + e.getMessage() );
        }

        return sectionNames;

    }

    public int giveTenToSome( int yearResultMax ){

        int updated = 0;

        try( Connection co = DriverManager.getConnection( CO_STRING, USERNAME, PSWD )){

            String requete = " UPDATE student SET year_result = 10 WHERE year_result <= ? ";
            PreparedStatement ps = co.prepareStatement(requete);

            ps.setInt(1, yearResultMax );

            updated = ps.executeUpdate();
        }
        catch ( SQLException e )
        {
            System.out.println("SQLException : "+ e.getMessage());
        }

        return updated;
    }

    public List<Student> getWithNameBegin( String nameBegin ){

        List<Student> studentList = new ArrayList<>();

        try( Connection co = DriverManager.getConnection( CO_STRING, USERNAME, PSWD )){

            String requete = "SELECT * FROM student WHERE last_name LIKE ? ";
            PreparedStatement ps = co.prepareStatement( requete );

            ps.setString( 1, nameBegin+"%" );

            ResultSet rs = ps.executeQuery();

            while( rs.next() ){

                Student resultat = new Student();
                resultat.setStudent_id( rs.getInt("student_id") );
                resultat.setFirst_name( rs.getString("first_name") );
                resultat.setLast_name( rs.getString("last_name") );
                resultat.setBirthdate( rs.getDate("birth_date") );
                resultat.setLogin( rs.getString("login") );
                resultat.setSection_id( rs.getInt("section_id") );
                resultat.setYear_result( rs.getInt("year_result") );
                resultat.setCourse_id( rs.getString("course_id") );

                studentList.add( resultat );
            }

        }
        catch ( SQLException e ) {
            System.out.println("SQLException : "+ e.getMessage());
        }

        return studentList;

    }

}
