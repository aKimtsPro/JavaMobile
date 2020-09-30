public class Voiture extends Vehicule {

    private String marque;

    @Override
    public void seDeplacer() {
        rouler();
    }

    public void rouler(){
        System.out.println("vroom vroom la voiture");
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
