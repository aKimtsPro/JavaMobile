package recap.exo.genericite;

public class CoureurF1 extends Sportif {

    private String marqueVehicule;

    public CoureurF1(String nom, String marqueVehicule) {
        super(nom);
        this.marqueVehicule = marqueVehicule;
    }

    public String getMarqueVehicule() {
        return marqueVehicule;
    }

    public void setMarqueVehicule(String marqueVehicule) {
        this.marqueVehicule = marqueVehicule;
    }
}
