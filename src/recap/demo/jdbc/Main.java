package recap.demo.jdbc;

import recap.demo.jdbc.model.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // region instatiation DAO

        StudentDAO studentDAO = new StudentDAO();

        System.out.println("--- get one ---");
        Student s = studentDAO.getById( 1 );

        if( s != null )
            System.out.println( s.getFirst_name() + " " + s.getLast_name() );
        else
            System.out.println("Cet etudiant n'est pas en DB.");



        System.out.println("--- get all ---");
        List<Student> students = studentDAO.getAll();

        students.forEach((student) -> System.out.println(student.getFirst_name() + " " + student.getLast_name()) );


        System.out.println("--- insert ---");

        Student s2 = new Student();
        s2.setStudent_id( 54 );
        s2.setFirst_name( "test" );
        s2.setLast_name("test");
        s2.setYear_result( 2 );
        s2.setCourse_id( "EG2210" );

        boolean inserted = studentDAO.insert(s2);
        System.out.println("inserted : " + inserted);


        System.out.println("--- update ---");
        s.setYear_result( 4 );

        boolean updated = studentDAO.update( s );
        System.out.println("updated = " + updated);


        System.out.println("---delete---");
        boolean deleted = studentDAO.delete(5048);
        System.out.println("deleted = " + deleted);


        System.out.println("--- section names ---");
        List<String> sectionNames = studentDAO.getSectionNameWithStudent();
        sectionNames.forEach( System.out::println );


        System.out.println("--- modif year_result ---");
        int givenTen = studentDAO.giveTenToSome( 2 );
        System.out.println( "nbr d'etudiants impactés : " + givenTen );


        System.out.println("--- get beginning with ---");
        List<Student> studs = studentDAO.getWithNameBegin("mi");
        studs.forEach( (student) -> System.out.println(student.getFirst_name() + " " + student.getLast_name()) );

        // endregion

    }
}
