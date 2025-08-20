package com.example.rebound.service;

import com.example.rebound.dto.CategoryDTO;
import com.example.rebound.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.selectAllCategories();
    }
}
