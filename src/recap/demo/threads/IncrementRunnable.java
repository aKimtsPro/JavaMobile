package recap.demo.threads;

public class IncrementRunnable implements Runnable{

    private int ressourcePartagee = 0;
    private final Object _key = new Object();

    public int getRessourcePartagee() {
        return ressourcePartagee;
    }

    public void setRessourcePartagee(int ressourcePartagee) {
        this.ressourcePartagee = ressourcePartagee;
    }

    public synchronized void increment(){
        ressourcePartagee++;
    }

    public void run2(){
        for (int i = 0; i < 10000; i++) {
            increment();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized ( _key ){
                ressourcePartagee++;
            }
        }
    }
}
