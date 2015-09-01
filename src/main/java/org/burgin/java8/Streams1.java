package org.burgin.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jonburgin on 8/24/15.
 * The basics, print out a list of names in uppercase
 */
public class Streams1 {


    public static void main(String args[]){
        List<String> names =Arrays.asList("Jon", "Burgin");

        for(String name: names){
                System.out.println(name.toUpperCase());
        }

        names.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}
