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
//    id           bigint unsigned auto_increment
//    primary key,
//    file_path    varchar(255)                       not null,
//    file_name    varchar(255)                       not null,
//    file_size    int      default 0                 null,
//    created_date datetime default CURRENT_TIMESTAMP null,
//    updated_date datetime default CURRENT_TIMESTAMP null
    private Long id;
    private String filePath;
    private String fileName;
    private int fileSize;
}
