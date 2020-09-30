package recap.demo.genericite;

import recap.demo.interfaces.Bateau;
import recap.demo.interfaces.Navigant;
import recap.demo.interfaces.Voiture;
import recap.demo.interfaces.VoitureAmphibie;

public class Main {

    public static void main(String[] args) {
        Boite<Navigant> b = new Boite<>();
        b.setContenu( new Bateau() );
        b.setContenu( new VoitureAmphibie() );
    }
}
