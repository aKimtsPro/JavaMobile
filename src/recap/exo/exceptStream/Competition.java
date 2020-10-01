package recap.exo.exceptStream;

import java.util.ArrayList;
import java.util.List;

public class Competition<C> {

    private Podium<C> podium;
    private List<C> participants = new ArrayList<>();
    private boolean isFinished = false;

    public Podium<C> getPodium() {
        return podium;
    }

    public List<C> getParticipants() {
        return participants;
    }

    public void setParticipants(List<C> participants) {
        this.participants = participants;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void finish(){
        if( isFinished )
        {
            System.out.println("Impossible de finir une competition déjà finie.");
            return;
        }

        if( participants.size() >= 3 ){
            isFinished = true;
            podium = new Podium<>();
            podium.setOr( participants.get(0) );
            podium.setArgent( participants.get(1) );
            podium.setBronze( participants.get(2) );
            System.out.println("La compétition est terminée");
        }
        else{
            System.out.println("Il n'y a pas assez de participant pour terminer la compet.");
        }

    }

    public C getWinner(){

        if( isFinished )
        {
            return podium.getOr();
        }
        return null;
    }

    public void addParticipant(C competiteur){
        if( participants.contains( competiteur ) ){
            throw new CourseException(competiteur, "compétiteur deja present");
        }

        participants.add(competiteur);
    }

    public void discalify(C competiteur){
        if( ! participants.contains( competiteur ) ){
            throw new CourseException(competiteur, "le competiteur ne participe pas à cette course");
        }

        participants.remove(competiteur);
    }


}
