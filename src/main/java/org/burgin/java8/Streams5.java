package org.burgin.java8;

import java.util.stream.Stream;

/**
 * Created by jonburgin on 8/25/15.
 *
 * Order of execution and effeciency
 *
 */
public class Streams5 {

    public static void main(String[] args){
        orderOfExecution();
        //shortCut();
    }

    static void orderOfExecution(){
        Stream.of("Do", "you", "know", "the", "way", "to", "San Jose")
                .peek(s -> System.out.println("Before filter " + s ))
                .filter(s -> true)
                .forEach(s -> System.out.println("After Filter " + s));
    }

    static void shortCut(){
        Stream.of("Who", "let", "the", "dogs", "out?")
                .anyMatch( s -> {
                    System.out.println("Matching " + s);
                    return s.startsWith("l");
                });

    }
}
