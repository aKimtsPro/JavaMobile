package nouveau.threads.demo;

public class RaceConditionDemo {

    public static void main(String[] args) {

        // On lance 2 thread sur mon IncrementRunnable
        // chaque thread veut incrémenter un meme variable 10000x

        // On devrait donc se retrouver avec la ressourcePartagée à 20000
        // à la fin des 2 threads

        IncrementRunnable runnable = new IncrementRunnable();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException ie){
            System.out.println("interrupted");
        }

        // On obtient bien 20000 une portion du temps mais parfois pas
        // Cette inconsistence provient d'une problème nommé race conditions
        System.out.println(" La ressource partagée est à : " + runnable.getRessourcePartagee() );

    }

}
