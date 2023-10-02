package multithreading;

public class ForSynchronized {
    public static int counter = 0;
    public static synchronized void increment(){
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Ex5());
        Thread thread2 = new Thread(new Ex5());
        Thread thread3 = new Thread(new Ex5());
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter);
    }
}

class Ex5 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<10000000;i++)
            ForSynchronized.increment();
    }
}
