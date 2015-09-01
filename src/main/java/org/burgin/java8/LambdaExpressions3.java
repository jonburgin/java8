package org.burgin.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaExpressions3 {

    interface Applier<T>{
        void apply(T t);
    }
    public static void main(String[] args){
        applyFunction( a -> System.out.println(a));
        acceptFunction(a -> System.out.println(a));
    }

    public static void applyFunction(Applier<String> f){
        f.apply("applyFunction calling!");
    }

    public static void acceptFunction(Consumer<String> f){ f.accept("acceptFunction calling!"); }
}
