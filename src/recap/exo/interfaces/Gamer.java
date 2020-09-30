package recap.exo.interfaces;

public class Gamer extends Personne implements Joueur {

    private String pseudo;


    public Gamer(String nom, String pseudo){
        super(nom);
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public void jouer() {
        System.out.println( this.pseudo + " joue.");
    }

    @Override
    public void gagner() {
        System.out.println( this.pseudo + "a gagné la partie.");
    }

    @Override
    public void perdre() {
        System.out.println(this.pseudo + "a perdu la partie, il détruit donc son clavier.");
    }
}
