package com.example.rebound.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@Setter
@EqualsAndHashCode(of = "id")
public class CategoryDTO {
    private Long id;
    private String categoryName;
    private String createdDate;
    private String updatedDate;
}
