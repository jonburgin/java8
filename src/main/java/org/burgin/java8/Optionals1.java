package org.burgin.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Optionals1 {
    static Random random = new Random();

    public static void main(String[] arg){
        Optional animal = Optional.of("cow");
        if(animal.isPresent())System.out.println(animal.get());

        Optional phrase = Optional.ofNullable(random.nextBoolean()? "play": null);
        System.out.println(phrase.orElse("go home"));
        System.out.println(phrase.orElseGet(() -> "funky"));
    }

}
