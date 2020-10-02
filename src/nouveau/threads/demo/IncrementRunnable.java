package nouveau.threads.demo;

public class IncrementRunnable implements Runnable{

    private int ressourcePartagee = 0;

    public int getRessourcePartagee() {
        return ressourcePartagee;
    }

    public void setRessourcePartagee(int ressourcePartagee) {
        this.ressourcePartagee = ressourcePartagee;
    }

    public synchronized void increment(){
        ressourcePartagee++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized ( this ){
                ressourcePartagee++;
            }
        }
    }
}
