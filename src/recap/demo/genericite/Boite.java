package recap.demo.genericite;

public class Boite<C> {

    private C contenu;

    public C getContenu() {
        return contenu;
    }

    public void setContenu(C contenu) {
        this.contenu = contenu;
    }
}
