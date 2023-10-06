package collection.map_interface;

import java.util.Arrays;

public class PublMentor {

    public static void main(String[] args) {
        int[] ints = {75, 87, 1, 5, 7, 6, 4, 15, 19, 25, 35, 48, 23};
        int number = 2;
        int[] result = getFromSum(ints, number);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] getFromSum(int[] ints, int number) {
        int[] result = new int[2];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] <= number) {
                int secondIndex = Arrays.binarySearch(ints, number - ints[i]);
                if (secondIndex >= 0 && secondIndex != i) {
                    result[0] = i;
                    result[1] = secondIndex;
                    return result;
                }
            }
        }
        return null;
    }
}
