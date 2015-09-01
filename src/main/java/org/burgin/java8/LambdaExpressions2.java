package org.burgin.java8;

import java.util.function.Supplier;

/**
 * Intance method created for each call
 */
public class LambdaExpressions2 {

    public static void main(String[] args){
        printSingleQuote(() -> "This string is single quoted");
        printDoubleQuote(() -> "This string is double quoted");
    }
    public static void printSingleQuote(Supplier<String> supplier) {
        String s = String.format("'%s'", supplier.get());
        System.out.println(s);
    }
    public static void printDoubleQuote(Supplier<String> supplier) {
        String s = String.format("\"%s\"", supplier.get());
        System.out.println(s);
    }
}
