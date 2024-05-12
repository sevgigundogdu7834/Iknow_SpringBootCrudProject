package Iknow_SpringBooot.CrudProject.mapper.Impl;

import Iknow_SpringBooot.CrudProject.dto.CategoryDto;
import Iknow_SpringBooot.CrudProject.entity.Category;
import Iknow_SpringBooot.CrudProject.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if(category == null){
            return null;
        }
        CategoryDto categoryDto= new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setProductList(category.getProductList());
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }

    @Override
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        if(categoryDto == null){
            return null;
        }
        Category category= new Category();
        category.setId(categoryDto.getId());
        category.setCategoryName(categoryDto.getCategoryName());
        category.setProductList(categoryDto.getProductList());
        return category;    }

    @Override
    public List<CategoryDto> categoryDtosToCategories(List<Category> categoryList) {
        if (categoryList.isEmpty()) {
            return null;
        }
        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add(categoryToCategoryDto(category));
        }
        return list;    }

    @Override
    public List<Category> categoriesToCategoryDtos(List<CategoryDto> categoryDtoList) {
        if (categoryDtoList.isEmpty()) {
            return null;
        }
        List<Category> list = new ArrayList<Category>( categoryDtoList.size() );
        for ( CategoryDto categoryDto : categoryDtoList ) {
            list.add( categoryDtoToCategory(categoryDto) );
        }
        return list;     }
}
