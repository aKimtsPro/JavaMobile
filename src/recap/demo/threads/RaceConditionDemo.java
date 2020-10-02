package recap.demo.threads;

public class RaceConditionDemo {

    public static void main(String[] args) {

        IncrementRunnable runnable = new IncrementRunnable();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(() -> runnable.setRessourcePartagee( runnable.getRessourcePartagee() + 1));

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException ie){
            System.out.println("interrupted");
        }

        System.out.println(" La ressource partagée est à : " + runnable.getRessourcePartagee() );

    }

}
