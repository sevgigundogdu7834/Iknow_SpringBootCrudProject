package Iknow_SpringBooot.CrudProject.service;

import Iknow_SpringBooot.CrudProject.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto create(CategoryDto categoryDto);
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    CategoryDto update(Long id, CategoryDto categoryDto);
    void delete(Long id);
    void deleteAll();

}
