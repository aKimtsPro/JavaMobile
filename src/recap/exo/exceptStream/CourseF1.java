package recap.exo.exceptStream;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class CourseF1 extends Competition<CoureurF1> {

    private int longueurCircuit;
    private int nbrTour;

    public CourseF1(int longueurCircuit, int nbrTour) {
        this.longueurCircuit = longueurCircuit;
        this.nbrTour = nbrTour;
    }

    @Override
    public void discalify(CoureurF1 competiteur) {
        super.discalify(competiteur);
        competiteur.setNbrDiscalification( competiteur.getNbrDiscalification() + 1 );
    }

    @Override
    public void finish() {
        super.finish();
        this.getParticipants().forEach(
                particip -> particip.setNbrKmParcouru( particip.getNbrKmParcouru() + (nbrTour * longueurCircuit))
        );
    }

    public void getMarques(){
        this.getParticipants().stream()
                .map( particip -> particip.getVoiture().getMarque() )
                .distinct()
                .forEach( System.out::println );
    }

    public List<CoureurF1> getWithMoreThan( int kmParcouru){
        return this.getParticipants().stream()
                .filter( particip -> particip.getNbrKmParcouru() > kmParcouru )
                .collect(Collectors.toList());
    }

    public int getTotalDiscalif(){

        OptionalInt optInt = this.getParticipants().stream()
                .mapToInt(CoureurF1::getNbrDiscalification)
                .reduce((int1 , int2) -> int1 + int2);

        if(optInt.isPresent())
            return optInt.getAsInt();

        return 0;
    }
}
