package com.example.rebound.audit;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString @Getter
@SuperBuilder
public abstract class Period {
    private String createdDate;
    private String updatedDate;
}