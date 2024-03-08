package com.javaevolution.lambda.collections;

import java.util.List;
import java.util.Objects;

public class FilteringExample {
    private FilteringExample() {
        throw new IllegalStateException("This is a util class");
    }

    public static List<String> filterNamesByFirstLetter(List<String> names, String letterToFilter){
        Objects.requireNonNull(names);
        Objects.requireNonNull(letterToFilter);

        return names.stream().filter(name -> name.startsWith(letterToFilter)).toList();
    }

}
