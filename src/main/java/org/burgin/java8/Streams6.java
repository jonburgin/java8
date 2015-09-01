package org.burgin.java8;

import org.burgin.java8.domain.Person;

import java.util.stream.Stream;

/**
 * Created by jonburgin on 8/25/15.
 *
 * Simple Map Reduce using Person
 *
 */
public class Streams6 {

    public static void main(String[] args){

        Stream<Person> personStream = Stream.of(new Person("Alice", 10), new Person("Bob", 21), new Person("Cathy", 100));

        int totalAge = personStream
          .map(person -> person.getAge())
          .reduce(0, Integer::sum);

        System.out.print(totalAge);

    }

}
