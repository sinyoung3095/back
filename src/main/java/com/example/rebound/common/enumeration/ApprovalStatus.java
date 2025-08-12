package com.example.rebound.common.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ApprovalStatus {
    APPROVAL("approval"), AWAIT("await"), REFUSAL("result");

    private final String value;
    private static final Map<String, Common> APRROVAL_STATUS_MAP =
            Arrays.stream(Common.values())
                    .collect(Collectors.toMap(Common::getValue, Function.identity()));

    ApprovalStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Common getValueFromType(String value) {
        return Optional.ofNullable(APRROVAL_STATUS_MAP.get(value)).orElseThrow(IllegalArgumentException::new);
    }
}
