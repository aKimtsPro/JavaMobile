package recap.exo.exceptStream;

public class Podium<P> {

    private P or;
    private P argent;
    private P bronze;

    public P getOr() {
        return or;
    }

    public void setOr(P or) {
        this.or = or;
    }

    public P getArgent() {
        return argent;
    }

    public void setArgent(P argent) {
        this.argent = argent;
    }

    public P getBronze() {
        return bronze;
    }

    public void setBronze(P bronze) {
        this.bronze = bronze;
    }
}
