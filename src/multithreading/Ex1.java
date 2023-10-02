package multithreading;

public class Ex1 {
    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1();
        MyThread2 m2 = new MyThread2();
        m1.start();
        m2.start();
    }
}

class MyThread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 1000; i++)
            System.out.println(i);
    }
}

class MyThread2 extends Thread{
    public void run() {
        for (int i = 1000; i > 0; i--)
            System.out.println(i);
    }
}
