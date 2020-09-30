package recap.exo;

public class Footballeur extends Personne implements Joueur {

    private int nbrGoal = 0;

    public Footballeur(String nom) {
        super(nom);
    }

    @Override
    public void jouer() {
        System.out.println(this.getNom() + "tape la balle.");
    }

    @Override
    public void gagner() {
        System.out.println(this.getNom() + "a gagné, c'est parti pour la 3e mi-temps");
    }

    @Override
    public void perdre() {
        System.out.println(this.getNom() + "a perdu, c'est parti pour la 3e mi-temps");
    }
}
