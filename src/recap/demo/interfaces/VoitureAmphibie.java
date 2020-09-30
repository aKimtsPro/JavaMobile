package recap.demo.interfaces;

public class VoitureAmphibie extends Voiture implements Navigant {

    public int poid;

    @Override
    public void rouler() {
        System.out.println("vroum vroum la voiture amphibie");
    }

    public void naviguer(){
        System.out.println("plouf plouf la voiture amphibie");
    }

}
