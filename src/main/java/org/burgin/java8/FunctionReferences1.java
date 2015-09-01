package org.burgin.java8;


import org.burgin.java8.domain.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Look at Person definition
 */
public class FunctionReferences1 {

    public static void main(String[] args){
        List<Person> persons = Arrays.asList(new Person("Alice",2),new Person("Bob",3));
        persons.sort(Comparator.comparing(person -> person.getName()));
        persons.sort(Comparator.comparing(Person::getAge));
        persons.sort(Comparator
                .comparing(Person::getName)
                .thenComparing(Person::getAge));

    }
}
