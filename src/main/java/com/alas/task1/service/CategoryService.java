package com.alas.task1.service;

import com.alas.task1.dto.Category.CategoryRequestDto;
import com.alas.task1.dto.Category.CategoryResponseDto;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto requestDto);
}
