package Iknow_SpringBooot.CrudProject.service.Impl;

import Iknow_SpringBooot.CrudProject.dao.CategoryDao;
import Iknow_SpringBooot.CrudProject.dao.ProductDao;
import Iknow_SpringBooot.CrudProject.dto.ProductDto;
import Iknow_SpringBooot.CrudProject.entity.Product;
import Iknow_SpringBooot.CrudProject.mapper.CategoryMapper;
import Iknow_SpringBooot.CrudProject.mapper.ProductMapper;
import Iknow_SpringBooot.CrudProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<ProductDto> getAll() {
        return productMapper.productDtosToProducts(productDao.findAll());
    }

    @Override
    public ProductDto getById(Long id) {
        return productMapper.productToProductDto(productDao.findById(id.intValue()).get());
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Product product=  productMapper.productDtoToProduct(productDto);
        Product savedProduct = productDao.save(product);
        return productMapper.productToProductDto(savedProduct);
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        Product product = productDao.findById(id.intValue()).get();
        Product savedProduct= null;
        if(product != null)
        {
            product.setProductName(productDto.getProductName());
            product.setUnitsInStock(productDto.getUnitsInStock());
            product.setQuantityPerUnit(productDto.getQuantityPerUnit());
            product.setCategory(categoryMapper.categoryDtoToCategory(productDto.getCategory()));
            product.setUnitPrice(productDto.getUnitPrice());
            savedProduct= productDao.save(product);
        }
        return productMapper.productToProductDto(savedProduct);
    }

    @Override
    public void delete(Long id) {
        productDao.deleteById(id.intValue());
    }

    @Override
    public void deleteAll() {
        productDao.deleteAll();

    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        List<Product> dtos= productDao.findByCategory_Id(categoryId);
        return dtos;
    }
}
