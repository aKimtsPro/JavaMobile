package nouveau.threads.exo;

public class Etrenne implements Runnable {

    private final Tirelire destinataire;
    private final int qtt;
    private final int timing;

    public Etrenne(Tirelire destinataire, int qtt, int timing) {
        this.destinataire = destinataire;
        this.qtt = qtt;
        this.timing = timing;
    }

    public Tirelire getDestinataire() {
        return destinataire;
    }

    public int getQtt() {
        return qtt;
    }

    public int getTiming() {
        return timing;
    }

    @Override
    public void run() {

        while(true){

            try{
                synchronized (destinataire){
                    destinataire.depot(qtt);
                }
                Thread.sleep(timing);
            }
            catch (InterruptedException ie){
                System.out.println("Thread interrupted");
            }

        }

    }
}
