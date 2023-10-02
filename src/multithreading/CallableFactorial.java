package multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class CallableFactorial {
    static int result = 0;

    public static void main(String[] args) {
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//        list.addAll();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        Future<Integer> future = executorService.submit(factorial);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }
    }
}

class Factorial implements Callable<Integer>{
    int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f<=0){
            throw new Exception("wrong number");
        }
        int result=1;
        for (int i = 1; i<=f;i++){
                 result*=i;
        }
        return result;
    }
}
