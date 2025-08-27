package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class FileVO extends Period {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileSize;
    private String fileContentType;
    private String fileOriginalName;
}
