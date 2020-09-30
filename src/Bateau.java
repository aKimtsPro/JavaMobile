public class Bateau extends Vehicule implements Navigant {

    private int longueur;

    @Override
    public void seDeplacer() {
        naviguer();
    }

    public void naviguer(){
        System.out.println("plouf plouf le bateau.");
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}
