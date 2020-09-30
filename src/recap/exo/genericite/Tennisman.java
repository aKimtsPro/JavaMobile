package recap.exo.genericite;

public class Tennisman extends Sportif {

    private String terrainFav;

    public Tennisman(String nom, String terrainFav) {
        super(nom);
        this.terrainFav = terrainFav;
    }

    public String getTerrainFav() {
        return terrainFav;
    }

    public void setTerrainFav(String terrainFav) {
        this.terrainFav = terrainFav;
    }
}
