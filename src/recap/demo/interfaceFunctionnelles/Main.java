package recap.demo.interfaceFunctionnelles;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Personne p = new Personne("luc");
        Nourriture n = new Nourriture("burger");

        // un parametre pas de retour
        Consumer<Nourriture> consume = (nourriture) -> p.manger(nourriture);
        consume = p::manger;

        System.out.println("Execution du consumer : ");
        consume.accept(n);


        // un retour sans parametre
        Supplier<String> supply = () -> n.getType();
        supply = n::getType;

        System.out.println("Execution du supplier : ");
        String retourSupplier = supply.get();
        System.out.println("retour : " + retourSupplier);


        // un parametre et un retour
        Function<String, Personne> function = (parameter) -> new Personne(parameter);
        function = Personne::new;

        System.out.println("Execution de la function : ");
        Personne pers = function.apply("marie");
        System.out.println("retour - personne de nom : " + pers.getNom());


        // un parametre et un retour boolean
        Predicate<String> predicate = (chaine) -> chaine.length() >= 10;

        System.out.println("Execution du predicate");
        boolean bool = predicate.test("ma chaine de caractère");
        System.out.println("Resultat du predicate : " + bool);
    }
}
