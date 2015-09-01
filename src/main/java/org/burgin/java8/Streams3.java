package org.burgin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jonburgin on 8/25/15.
 *
 * Example of filtering words and creation of new streams(lists)
 *
 */
public class Streams3 {
    public static void main(String args[]) {
        List<String> words = Arrays.asList("I", "can't", "find", "my", "shoes");
        System.out.println(iterativeSmallWords(words));
        System.out.println(streamSmallWords(words));
    }

    private static List<String> iterativeSmallWords(List<String> words) {
        ArrayList<String> newList = new ArrayList<>();
        for(String word:words){
            if(word.length()< 3){
                newList.add(word);
            }
        }
        return newList;
    }

    private static List<String> streamSmallWords(List<String> words) {
        return words.stream()
          .filter(w -> w.length() < 3)
          .collect(Collectors.toList());
    }
}
