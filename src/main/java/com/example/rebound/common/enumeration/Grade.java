package com.example.rebound.common.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Grade {
    MENTOR("mentor"), NONE("none"), SUBSCRIBE("subscribe") ;

    private final String value;
    private static final Map<String, Grade> MENTOR_MAP =
            Arrays.stream(Grade.values())
                    .collect(Collectors.toMap(Grade::getValue, Function.identity()));

    Grade(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Grade getMentorFromValue(String value) {
        return Optional.ofNullable(MENTOR_MAP.get(value)).orElseThrow(IllegalArgumentException::new);
    }
}
