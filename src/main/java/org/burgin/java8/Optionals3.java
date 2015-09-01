package org.burgin.java8;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Optionals3 {

    @Data
    static class Body{
        Skull skull;
    }

    @Data
    static class Skull{
        Brain brain;
    }

    @Data
    static class Brain{
        Thought thought;
    }

    static class Thought{
    }

    public static void main(String[] arg){
        Body body = new Body();
        if((body != null) &&
           (body.getSkull() != null) &&
           (body.getSkull().getBrain() != null) &&
           (body.getSkull().getBrain().getThought() != null)){
            //think something
        }

        Optional<Body> someBody  = Optional.ofNullable(new Body());
        someBody.map(Body::getSkull)
                .map(Skull::getBrain)
                .map(Brain::getThought)
                .ifPresent((thought)->{
                //think something
                });
    }
}
