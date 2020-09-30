package recap.exo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Joueur j1 =  new Gamer("luc", "xxx_luc_xxx");
        Joueur j2 = new Footballeur("louis");

        List<Joueur> list = new ArrayList<>( Arrays.asList(j1, j2) );



        for (Joueur j :
                list) {
            j.jouer();
        }
    }

}
