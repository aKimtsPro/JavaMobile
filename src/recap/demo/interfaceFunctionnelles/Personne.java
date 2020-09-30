package recap.demo.interfaceFunctionnelles;

public class Personne {

    private String nom;

    public Personne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void manger(Nourriture food){
        System.out.println( this.nom + " mange de la nourriture de type : "+ food.getType());
    }
}
