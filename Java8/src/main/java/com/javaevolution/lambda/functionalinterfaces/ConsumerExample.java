package com.javaevolution.lambda.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    private ConsumerExample() {
        throw new IllegalStateException("This is util class");
    }

    //This is the consumer that receives a String and print it in console
    private static final Consumer<? super Object> printConsumer = System.out::println;

    static void printString(String text) {
        printConsumer.accept(text);
    }

    static <T> void printCollection(List<T> list){
        list.forEach(printConsumer);
    }

}
