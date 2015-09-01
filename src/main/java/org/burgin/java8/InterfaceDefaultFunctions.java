package org.burgin.java8;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

/**
 * Examine Consumer Interface first
 */
public class InterfaceDefaultFunctions {

    public static void main(String[] args){
        NamedConsumer adam = new NamedConsumer("Adam");
        NamedConsumer eve = new NamedConsumer("Eve");
        eve.andThen(adam)
                .accept("apple");
    }

    @Data
    static class NamedConsumer implements Consumer<String>{

        final public String name;

        @Override
        public void accept(String stringToBeConsumed) {
            System.out.println(String.format("%s is here consumming '%s'", name, stringToBeConsumed));
        }
    }
}
