package recap.demo.threads;

public class Main {

    public static void main(String[] args) {

        String salutation = "salut";

        // instanciation d'un Thread

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( salutation );
            }
        });

        th = new Thread( () -> {
            System.out.println( salutation );
        } );


        th = new Thread( new ClassRunnable() );
        th.setName("mon thread");

        th.start();
        System.out.println("thread commencée");

        try{
            System.out.println( Thread.currentThread().getName() );
            th.join();
        }
        catch (InterruptedException ie)
        {
            System.out.println( ie );
        }

        System.out.println("thread terminé");

    }
}
