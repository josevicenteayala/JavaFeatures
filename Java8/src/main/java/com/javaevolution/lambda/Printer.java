package com.javaevolution.lambda;

import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Printer {

    public static final String DELIMITER = "";

    private Printer(){
        //This prevents to create classes from this class
    }

    public static void printLogger(Logger logger, String message, List<String> strings) {
        Supplier<String> stringSupplier = () -> message;
        logger.info(stringSupplier);
        String collect = String.join(DELIMITER, strings);
        logger.info(collect);
    }

    public static void printLogger(Logger logger, String message) {
        logger.info(() -> message);
    }
}
