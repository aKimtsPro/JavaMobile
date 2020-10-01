package recap.exo.exceptStream;

public class CoureurF1 extends Sportif {

    private Voiture voiture;
    private int nbrKmParcouru;
    private int nbrDiscalification;

    public CoureurF1(String nom, Voiture voiture) {
        super(nom);
        this.voiture = voiture;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public int getNbrKmParcouru() {
        return nbrKmParcouru;
    }

    public void setNbrKmParcouru(int nbrKmParcouru) {
        this.nbrKmParcouru = nbrKmParcouru;
    }

    public int getNbrDiscalification() {
        return nbrDiscalification;
    }

    public void setNbrDiscalification(int nbrDiscalification) {
        this.nbrDiscalification = nbrDiscalification;
    }

    @Override
    public void setNom(String nom) {
        if( nom.length() < 4 || nom.length() > 30 )
            throw new IllegalArgumentException("Le nom doit faire entre 4 et 30 chars");

        super.setNom( nom );
    }
}
