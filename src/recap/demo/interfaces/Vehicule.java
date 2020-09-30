package recap.demo.interfaces;

public class Vehicule {

    private int puissance;

    public void seDeplacer(){
        System.out.println("Le vehicule se déplace");
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}
