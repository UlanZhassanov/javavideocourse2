package multithreading;

public class Ex2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable2());
        thread1.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 1000; i++)
            System.out.println(i);
    }
}

class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 1000; i > 0; i--)
            System.out.println(i);
    }
}
