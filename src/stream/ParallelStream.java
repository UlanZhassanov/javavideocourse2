package stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.25);
        list.add(5.4);
        list.add(6.00);
        list.add(56.00);
        list.add(12.25);
        list.add(3.5);

        double sum = list.parallelStream().reduce((accumulator, e)->accumulator+e).get();
        System.out.println(sum);
    }
}
