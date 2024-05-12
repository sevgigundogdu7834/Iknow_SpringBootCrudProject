package Iknow_SpringBooot.CrudProject.mapper.Impl;

import Iknow_SpringBooot.CrudProject.dto.ProductDto;
import Iknow_SpringBooot.CrudProject.entity.Product;
import Iknow_SpringBooot.CrudProject.mapper.CategoryMapper;
import Iknow_SpringBooot.CrudProject.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ProductDto productToProductDto(Product product) {

        if(product == null){
            return null;
        }
        ProductDto productDto= new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setCategory(categoryMapper.categoryToCategoryDto(product.getCategory()));
        productDto.setUnitPrice(product.getUnitPrice());
        productDto.setUnitsInStock(product.getUnitsInStock());
        productDto.setQuantityPerUnit(product.getQuantityPerUnit());

        return productDto;
    }

    @Override
    public Product productDtoToProduct(ProductDto productDto) {

        if(productDto == null){
            return null;
        }
        Product product= new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setCategory(categoryMapper.categoryDtoToCategory(productDto.getCategory()));
        product.setUnitPrice(productDto.getUnitPrice());
        product.setUnitsInStock(productDto.getUnitsInStock());
        product.setQuantityPerUnit(productDto.getQuantityPerUnit());

        return product;
    }

    @Override
    public List<ProductDto> productDtosToProducts(List<Product> productList) {
        if (productList.isEmpty()) {
            return null;
        }
        List<ProductDto> list = new ArrayList<ProductDto>( productList.size() );
        for ( Product product : productList ) {
            list.add( productToProductDto(product) );
        }

        return list;
    }

    @Override
    public List<Product> productsToProductDtos(List<ProductDto> productDtoList) {
        if (productDtoList.isEmpty()) {
            return null;
        }
        List<Product> list = new ArrayList<Product>( productDtoList.size() );
        for ( ProductDto productDto : productDtoList ) {
            list.add( productDtoToProduct(productDto) );
        }

        return list;    }
}
