package Iknow_SpringBooot.CrudProject.service;

import Iknow_SpringBooot.CrudProject.dto.ProductDto;
import Iknow_SpringBooot.CrudProject.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto productDto);
    List<ProductDto> getAll();
    ProductDto getById(Long id);
    ProductDto update(Long id, ProductDto productDto);
    void delete(Long id);
    void deleteAll();
    List<Product> getProductsByCategoryId(Long categoryId);
}
