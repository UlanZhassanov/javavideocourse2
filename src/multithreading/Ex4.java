package multithreading;

public class Ex4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi!");
            }
        }).start();
        new Thread(()-> System.out.println("hello")).start();
    }
}
 