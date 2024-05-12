package Iknow_SpringBooot.CrudProject.service.Impl;

import Iknow_SpringBooot.CrudProject.dao.CategoryDao;
import Iknow_SpringBooot.CrudProject.dto.CategoryDto;
import Iknow_SpringBooot.CrudProject.entity.Category;
import Iknow_SpringBooot.CrudProject.entity.Product;
import Iknow_SpringBooot.CrudProject.mapper.CategoryMapper;
import Iknow_SpringBooot.CrudProject.mapper.ProductMapper;
import Iknow_SpringBooot.CrudProject.service.CategoryService;
import Iknow_SpringBooot.CrudProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<CategoryDto> getAll() {
        return categoryMapper.categoryDtosToCategories(categoryDao.findAll());
    }

    @Override
    public CategoryDto getById(Long id) {
        return categoryMapper.categoryToCategoryDto(categoryDao.findById(id.intValue()).get());
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        List<Product> productList= new ArrayList<>();
        if(!categoryDto.getProductList().isEmpty()){
            for(Product productIn : categoryDto.getProductList()){
                Product product= new Product();
                product.setId(productIn.getId());
                product.setProductName(productIn.getProductName());
                product.setUnitsInStock(productIn.getUnitsInStock());
                product.setQuantityPerUnit(productIn.getQuantityPerUnit());
                product.setUnitPrice(productIn.getUnitPrice());
                product.setCategory(categoryMapper.categoryDtoToCategory(categoryDto));
                productList.add(product);
            }
        }
        categoryDto.setProductList(productList);
        Category savedCategory = categoryDao.save(categoryMapper.categoryDtoToCategory(categoryDto));
        return categoryMapper.categoryToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        Category category = categoryDao.findById(id.intValue()).get();
        Category savedCategory= null;
        if(category != null)
        {
            category.setCategoryName(categoryDto.getCategoryName());
            category.setProductList(categoryDto.getProductList());
            savedCategory= categoryDao.save(category);
        }
        return categoryMapper.categoryToCategoryDto(savedCategory);
    }

    @Override
    public void delete(Long id) {
        categoryDao.deleteById(id.intValue());
    }

    @Override
    public void deleteAll() {
        categoryDao.deleteAll();
    }
}
