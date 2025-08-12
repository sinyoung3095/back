package com.example.rebound.common.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Common {
    ADMIN("admin"), NONE("none");

    private final String value;
    private static final Map<String, Common> TYPE_MAP =
            Arrays.stream(Common.values())
                            .collect(Collectors.toMap(Common::getValue, Function.identity()));

    Common(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Common getValueFromType(String value) {
        return Optional.ofNullable(TYPE_MAP.get(value)).orElseThrow(IllegalArgumentException::new);
    }
}
