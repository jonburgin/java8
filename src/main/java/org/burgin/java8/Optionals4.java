package org.burgin.java8;

import lombok.Data;

import java.util.Optional;

public class Optionals4 {

    @Data
    static class Body{
        Optional<Skull> skull;
    }

    @Data
    static class Skull{
        Optional<Brain> brain;
    }

    @Data
    static class Brain{
        Optional<Thought> thought;
    }

    static class Thought{
    }

    public static void main(String[] arg){

        Optional<Body> someBody  = Optional.ofNullable(new Body());
//        someBody.map(Body::getSkull)
//                .map(Skull::getBrain)
//                .map(Brain::getThought)
//                .ifPresent((thought) -> {
//                    //think something
//                });
    }
}
