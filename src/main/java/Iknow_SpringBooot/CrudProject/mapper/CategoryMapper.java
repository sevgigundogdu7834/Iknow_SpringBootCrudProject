package Iknow_SpringBooot.CrudProject.mapper;

import Iknow_SpringBooot.CrudProject.dto.CategoryDto;
import Iknow_SpringBooot.CrudProject.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto categoryToCategoryDto (Category category);

    Category categoryDtoToCategory(CategoryDto categoryDto);

    List<CategoryDto> categoryDtosToCategories(List<Category> categoryList);

    List<Category> categoriesToCategoryDtos(List<CategoryDto> categoryDtoList);
}
