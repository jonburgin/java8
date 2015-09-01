package org.burgin.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Optionals2 {
    static Random random = new Random();
    public static Optional<String> invite(String name){
       return random.nextBoolean()? Optional.of(name) : Optional.empty();
    }

    public static void main(String[] arg){
        List<String> friends = Arrays.asList("Ann", "Al", "Betty", "Bob");
        List<Optional<String>> attendees = friends.stream()
                .map(Optionals2::invite)
                .filter(Optional::isPresent)
                .collect(Collectors.toList());
        System.out.println(attendees);
    }
}
