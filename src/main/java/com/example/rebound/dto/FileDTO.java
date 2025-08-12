package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FileDTO {
    private Long id;
    private String filePath;
    private String fileName;
    private int fileSize;
    private String createdDatetime;
    private String updatedDatetime;
}
