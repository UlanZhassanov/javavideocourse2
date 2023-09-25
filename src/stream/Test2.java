package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hey");
        list.add("aaa");
        list.add("ssssss");
        list.add("ioasf");
        list.add("njks");
        list.add("d");
        list.add("uykiuig");

//        REDUCE
        String a = list.stream().reduce((accumulator, element) -> (accumulator + " | " + element)).get();
        System.out.println(a);

        String aa = list.stream().reduce("Aa", (accumulator, element) -> (accumulator + " | " + element));
        System.out.println(aa);

//        aa.chars().forEach(System.out::println);


        List<Integer> listInt = new ArrayList<>();
        Optional<Integer> b = listInt.stream().reduce((accumulator, element) -> accumulator + element);
        if (b.isPresent()) {
            System.out.println(b.get());
        } else {
            System.out.println("Not present");
        }

//        SORTED
        int[] arr = {3, 5, 8, 9, 7, 4, 2, 1, 11, 15, 68, 56, 23, 74, 8};
        arr = Arrays.stream(arr).sorted().toArray();
        System.out.println(Arrays.toString(arr));


//        METHOD CHAINING
        int result = Arrays.stream(arr)
                .filter(e -> e % 2 == 0)
                .map(e -> {
//                    if (e / 10 > 1) {
                    e = e * 1000;
//                    }
                    return e;
                })
                .reduce((acc, e) -> acc + e).getAsInt();
        System.out.println(result);
        System.out.println("------------------------\n");

        //DISTINCT
        System.out.println(Arrays.toString(Arrays.stream(arr).distinct().toArray()));
        System.out.println("------------------------\n");

        //MAP_TO_INT, BOXED
        List<Integer> listtoIntList = list.stream()
                .mapToInt(el -> el.length())
                .boxed()
                .collect(Collectors.toList());
        System.out.println(listtoIntList);
        System.out.println("------------------------\n");

        System.out.println(list.stream().mapToInt(el->el.length()).max().getAsInt());
        System.out.println(list.stream().mapToInt(el->el.length()).sum());
        System.out.println(list.stream().mapToInt(el->el.length()).min().getAsInt());
        System.out.println(list.stream().mapToInt(el->el.length()).count());
        System.out.println(list.stream().mapToInt(el->el.length()).average().getAsDouble());
    }
}
