package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hey");
        list.add("aaa");
        list.add("ssssss");
        list.add("ioasf");
        list.add("njks");
        list.add("d");
        list.add("uykiuig");

        //FILTER
        Stream<String> myStream = Stream.of("Aaaa", "Bbbb", "Cccc");
        List<String> stringList = myStream.filter(el -> el.contains("b")).collect(Collectors.toList());
        System.out.println(stringList);
        System.out.println("------------------------\n");

        //MAP, FILTER
        List<Integer> list2 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        List<String> list3 = list.stream().filter(element -> element.length() > 2).collect(Collectors.toList());
        list.stream().forEach(el -> {
            el = el + " 001";
            System.out.println(el);
        });
        System.out.println("------------------------\n");
        System.out.println(list2);
        System.out.println("------------------------\n");
        System.out.println(list3);
        System.out.println("------------------------\n");

        int[] arr = {1, 5, 9, 7, 2, 3, 99};
        int[] arr2 = Arrays.stream(arr).map(num -> {
            if (num % 3 == 0) {
                num *= 100;
            }
            return num;
        }).toArray();

        //FOREACH
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("------------------------\n");
        Arrays.stream(arr).forEach(Test::myMethod);
        System.out.println("------------------------\n");

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        //GROUPING_BY
        Map<Integer, List<String>> map = list.stream().map(el -> (el + "aaa")).collect(Collectors.groupingBy(el -> {
                    if (el.startsWith("a"))
                        return 1;
                    else if (el.startsWith("s"))
                        return 2;
                    else
                        return 3;
                }
        ));

        for (
                Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("------------------------\n");

        //PARTITIONING_BY
        Map<Boolean, List<String>> map2 = list.stream().map(el -> (el + "aaa")).collect(Collectors.partitioningBy(el -> el.length() > 7));
        for (
                Map.Entry<Boolean, List<String>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    public static void myMethod(int a) {
        a *= 1000;
        System.out.println(a);
    }
}
