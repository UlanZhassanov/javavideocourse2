package Generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenMethod {


    public <T> boolean compareArrays(T arr1[], T arr2[]){
        if (arr1 != arr2){
            return false;
        }
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(25);
        list.add(1,0);
        String[] sd = new String[10];
        list.remove(Integer.valueOf(0));
        System.out.println(list);
        System.out.println(list.getClass());

        Map<Integer, String> mapp = new HashMap<>();
        mapp.put(1,"dfdf");
        mapp.put(2,"dfdf");
        mapp.put(3,"dfdf");
        mapp.put(4,"dfdf");
        mapp.put(5,"dfdf");

        System.out.println(mapp.keySet());
        System.out.println(mapp.values());
        System.out.println(mapp.remove(1));
    }
}
