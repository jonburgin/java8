package org.burgin.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions1 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 3, 2);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });
        System.out.println(list);

    }
}
