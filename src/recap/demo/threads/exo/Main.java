package recap.demo.threads.exo;

public class Main {

    public static void main(String[] args) {

        Tirelire t = new Tirelire();
        Tirelire t2 = new Tirelire();
        GrandMere gm = new GrandMere();

        gm.lancerEtrenne(t, 3, 3000);
        gm.lancerEtrenne(t, 10, 5000);

        gm.lancerEtrenne(t2, 10, 5000);

    }
}
