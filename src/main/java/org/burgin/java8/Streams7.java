package org.burgin.java8;

import org.burgin.java8.domain.House;
import org.burgin.java8.domain.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jonburgin on 8/25/15.
 *
 * flatMap using House and Person
 */
public class Streams7 {

    static List<House> generateHouses(){
        List<House> houses = Arrays.asList(new House(Arrays.asList(new Person("Alice",10), new Person("Bob",20))),
                                           new House(Arrays.asList(new Person("Cathy", 30), new Person("Doug", 40))));
        return houses;
    }

    static public void main(String[] args){
        List<House> neighborhood = generateHouses();
        neighborhood.stream()
          .flatMap(house -> house.getPersons().stream())
          .map(Person::getName)
          .forEach(System.out::println);
    }
}
