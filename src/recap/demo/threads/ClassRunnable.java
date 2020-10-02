package recap.demo.threads;

public class ClassRunnable implements Runnable {

    public final String message = "running in the class";

    @Override
    public void run() {
        try{
            System.out.println( message + " - " + Thread.currentThread().getName() );
            Thread.sleep( 3000 );
        }
        catch (InterruptedException ie)
        {
            System.out.println( ie );
        }
        System.out.println("thread end");
    }
}
