package collection.map_interface;

import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        TreeMap<Double, String> treeMap = new TreeMap<>();
        treeMap.put(4.5, "Jack");
        treeMap.put(5.5, "SS");
        treeMap.put(7.5, "WW");
        treeMap.put(2.5, "RR");
        System.out.println(treeMap);


        System.out.println(treeMap.descendingMap());
    }

}
