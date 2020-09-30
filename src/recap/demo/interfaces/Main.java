package recap.demo.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Navigant nav = new VoitureAmphibie();

        List<Navigant> listNav = new ArrayList<>();

        listNav.add(nav);
        listNav.add(new Bateau());

        for ( Navigant n : listNav ) {
            n.naviguer();
        }

    }
}
