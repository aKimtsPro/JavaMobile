package nouveau.optionals;

import recap.exo.interfaces.Personne;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<Personne>  list = new ArrayList<>();

        Personne p1 = new Personne("luc");
        Personne p2 = null;

        Optional<Personne> personneOptionnelle = list.stream().findFirst();


        // Créer un Optional

        Optional opt = Optional.empty();
        opt = Optional.of(p1);
        opt = Optional.ofNullable(p2);


        // verifier la présence d'une info
        boolean infoPresente = personneOptionnelle.isPresent();

        // si l'optional est vide renvoie une autre optional, sinon, renvoie l'Opt. actuel
        personneOptionnelle = personneOptionnelle.or(() -> Optional.of(p2));

        // recupere l'info (ou une autre si l'optional est vide)
        p1 = personneOptionnelle.orElse(p1);

        // recupere l'info (ou le resultat du supplier si vide)
        p1 = personneOptionnelle.orElseGet(() -> new Personne("marie"));

        // meme chose que le get (NoSuchElementException)
        p1 = personneOptionnelle.orElseThrow();

        // meme chose que le get (Throwable de notre choix)
        p1 = personneOptionnelle.orElseThrow( () -> new RuntimeException("L'exception que je choisi") );

    }
}
