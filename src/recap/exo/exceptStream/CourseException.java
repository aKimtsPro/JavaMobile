package recap.exo.exceptStream;

public class CourseException extends RuntimeException {

    private Object competiteur;

    public CourseException(Object competiteur, String message) {
        super(message);
        this.competiteur = competiteur;
    }

    public Object getCompetiteur() {
        return competiteur;
    }

    public void setCompetiteur(Object competiteur) {
        this.competiteur = competiteur;
    }
}
