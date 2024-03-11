package com.javaevolution.lambda.methodreferences;

import java.util.List;
import java.util.Objects;

public class InstanceMethodArbitraryObject {

    private InstanceMethodArbitraryObject() {
        throw new IllegalStateException("This is a util class");
    }

    public static List<String> sortStringsAlphabetically(List<String> texts){
        Objects.requireNonNull(texts);

        texts.sort(String::compareToIgnoreCase);

        return texts;
    }

}
