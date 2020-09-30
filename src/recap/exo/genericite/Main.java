package recap.exo.genericite;

public class Main {

    public static void main(String[] args){

        Competition<CoureurF1> course = new Competition<>();
        course.getParticipants().add( new CoureurF1("luc", "wmb") );
        course.getParticipants().add( new CoureurF1( "marie", "fuufu") );

        course.finish();

        course.getParticipants().add( new CoureurF1( "dominique", "pamplemousse") );

        course.finish();
        System.out.println("le grand gagnant est " +  course.getWinner().getNom());

    }
}
