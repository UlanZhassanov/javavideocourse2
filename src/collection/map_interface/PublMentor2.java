package collection.map_interface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PublMentor2 {
    public static void main(String[] args) {
        int[] ints = {1, 5, 7, 6, 4, 15, 19, 25, 35, 48, 23};
        System.out.println(hasDuplicate(ints));
        System.out.println(hasDuplicateSolvedWithSet(ints));
    }


    public static boolean hasDuplicate(int[] ints) {
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            int duplicate = Arrays.binarySearch(ints, i + 1, ints.length, ints[i]);
            if (duplicate > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicateSolvedWithSet(int[] ints) {
        Set<Integer> intSet = new HashSet<>();

        for (int num :
                ints) {
            if (intSet.contains(num)) {
                return true;
            }
            intSet.add(num);
        }

        return false;
    }
}
