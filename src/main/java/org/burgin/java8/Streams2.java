package org.burgin.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jonburgin on 8/24/15.
 */
public class Streams2 {

    /**
     * Given a list of words:
     *     "word1", "word2", "word3", "word4"
     *
     * Desire json of the captilized version like this:
     * { "mywords": ["WORD1", "WORD2", "WORD3", "WORD4"] }
     *
     */

    public static void main(String args[]) {
        List<String> names = Arrays.asList("Jon", "Burgin", "is", "fugly");
        System.out.println(java7json(names));
        System.out.println(java8json(names));
    }

    private static String java7json(List<String> names) {
        StringBuilder builder = new StringBuilder("{ \"mywords\": [");
        for(String name: names){
            builder.append(name.toUpperCase());
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("] }");
        return builder.toString();
    }

    private static String java8json(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(",", "{ \"mywords\": [", "] }"));

    }

    //This doesn't do uppercase, but is for simple case
    private static String java8jsonWithoutStream(List<String> names){
        return "{ \"mywords\": [" + String.join(",",names) + "] }";
    }

}
