package com.example.rebound.mapper;

import com.example.rebound.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<CategoryDTO> selectAllCategories();
}
