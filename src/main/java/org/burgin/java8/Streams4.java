package org.burgin.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Created by jonburgin on 8/25/15.
 *
 * Performance
 *
 */
public class Streams4 {

    static protected void doSomeWork(int number){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(number);
    }

    static void iterativeWork(int quantity){
        for(int i=0; i < quantity; i++)
            doSomeWork(i);
    }

    static void streamWork(int quantity){
        IntStream.range(0,quantity)
                .forEach(Streams4::doSomeWork);
    }

    static void timer(int value, IntConsumer consumer){
        long start = System.currentTimeMillis();
        consumer.accept(value);
        System.out.println(String.format(" Time taken = %f seconds", (System.currentTimeMillis() - start) / 1000f));
    }

    public static void main(String args[]) {
        timer(5, Streams4::iterativeWork);
        timer(5, Streams4::streamWork);
    }

}
