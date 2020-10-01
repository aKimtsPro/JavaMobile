package recap.exo.exceptStream;

import java.time.LocalDate;

public class Voiture {

    private String marque;
    private LocalDate dateConstruction;

    public Voiture(String marque, LocalDate dateConstruction) {
        this.marque = marque;
        this.dateConstruction = dateConstruction;
    }

    public String getMarque() {
        return marque;
    }

    private void setMarque(String marque) {
        this.marque = marque;
    }

    public LocalDate getDateConstruction() {
        return dateConstruction;
    }

    private void setDateConstruction(LocalDate dateConstruction) {
        this.dateConstruction = dateConstruction;
    }
}
