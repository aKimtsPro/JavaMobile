package nouveau.threads.exo;

public class GrandMere {

    public void lancerEtrenne( Tirelire tirelire, int qtt, int timing ){
        Thread th = new Thread( new Etrenne(tirelire, qtt, timing) );
        th.start();
    }

}
