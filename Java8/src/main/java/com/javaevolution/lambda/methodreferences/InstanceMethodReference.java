package com.javaevolution.lambda.methodreferences;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InstanceMethodReference {

    public List<String> cleanNonAlphabeticCharacters(List<String> texts) {
        Objects.requireNonNull(texts);

        return texts.stream().map(this::removeNonAlphabeticCharacters).toList();
    }

    private String removeNonAlphabeticCharacters(String text) {
       return text.chars()
               .filter(Character::isAlphabetic)
               .mapToObj(c -> String.valueOf((char)c))
               .collect(Collectors.joining());
    }

}
