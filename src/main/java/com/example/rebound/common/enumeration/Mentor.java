package com.example.rebound.common.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Mentor {
    MENTOR("mentor"), NONE("none"), SUBSCRIBE("subscribe") ;

    private final String value;
    private static final Map<String, Mentor> MENTOR_MAP =
            Arrays.stream(Mentor.values())
                    .collect(Collectors.toMap(Mentor::getValue, Function.identity()));

    Mentor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Mentor getMentorFromValue(String value) {
        return Optional.ofNullable(MENTOR_MAP.get(value)).orElseThrow(IllegalArgumentException::new);
    }
}
