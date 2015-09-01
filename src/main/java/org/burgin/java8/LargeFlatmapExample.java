package org.burgin.java8;

import org.burgin.java8.domain.City;
import org.burgin.java8.domain.House;
import org.burgin.java8.domain.Person;
import org.burgin.java8.domain.Street;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * We have some cities, which have streets, which have houses, which have people.
 * We want a list of the names of all people that are of adult age.
 */
public class LargeFlatmapExample {


    public static void main(String[] args){
        List<City> cities = populateCity();
        City foo[] = {};
        System.out.println(findAdultIteratively(cities.toArray(foo)));
        System.out.println(findAdultsViaStream(cities.toArray(foo)));
    }

    public static List<String> findAdultIteratively(City cities[]){
        ArrayList<String> names = new ArrayList<>();
        for(City city:cities){
            for(Street street: city.getStreets()){
                for(House house : street.getHouses()){
                    for(Person person: house.getPersons()){
                        if(person == null || person.getAge() < 18){
                            continue;
                        }
                        names.add(person.getName());
                    }
                }
            }
        }
        return names;
    }

    public static List<String> findAdultsViaStream(City cities[]){
        return Arrays.stream(cities)
                .flatMap(city -> city.getStreets().stream())
                .flatMap(street -> street.getHouses().stream())
                .flatMap(house -> house.getPersons().stream())
                .filter(person -> person != null)
                .filter(person -> person.getAge() >= 18)
                .map(Person::getName)
                .collect(Collectors.toList());
    }


    static List<Person> peopleList = Arrays.asList(new Person("Alice",15),
            new Person("Bob",18),
            new Person("Clarice",5),
            new Person("Dirk",25),
            new Person("Elise",1),
            new Person("Frank",35),
            new Person("Gerta",17),
            new Person("Hank",65)
    );
    static Iterator<List<Person>> peopleListIterator;

    public static List<House> generateHouses(int number){
        if(peopleListIterator == null){
            peopleListIterator = peopleList.stream()
                    .collect(new PartitionBySizeCollector<Person>(number)).iterator();
        }
        return IntStream.range(0, number)
                .mapToObj(i -> new House(peopleListIterator.next()))
                .collect(Collectors.toList());
    }

    public static List<Street> generateStreets(int number){
        return IntStream.range(0,number)
                .mapToObj(i -> new Street(generateHouses(number)))
                .collect(Collectors.toList());
    }

    public static List<City> generateCities(int number){
        return IntStream.range(0,number)
                .mapToObj(i -> new City(generateStreets(number)))
                .collect(Collectors.toList());

    }

    public static List<City> populateCity(){
        int size = 2;
        List<City> cities = generateCities(size);
        return cities;
    }


    static class PartitionBySizeCollector<T> implements Collector<T, List<List<T>>,List<List<T>>>{

        int collectionSize = 2;
        List<List<T>> listOfLists;
        public PartitionBySizeCollector(int collectionSize){
            this.collectionSize = collectionSize;
        }

        @Override
        public Supplier supplier() {
            return  () -> {
                if(listOfLists == null)
                    listOfLists = new ArrayList<>();
                return listOfLists;
            };
        }

        @Override
        public BiConsumer accumulator() {
            return (a, t) -> {
                List<List<T>> ll = (List<List<T>>) a;
                if(ll.isEmpty() || (ll.get(ll.size() -1).size()< collectionSize))
                    ll.add(new ArrayList<T>());
                ll.get(ll.size() -1).add((T)t);
            } ;
        }

        @Override
        public BinaryOperator combiner() {
            return (a, b) -> {
                ((List<List<T>>)a).addAll((List<List<T>>)b);
                return a;
            };
        }

        @Override
        public Function finisher() {
            return (a) -> a;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return EnumSet.of(Characteristics.CONCURRENT, Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED);
        }
    }
}
