package com.example.rebound.mapper;

import com.example.rebound.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
//    추가
    public void insertFile(FileDTO fileDTO);
}
