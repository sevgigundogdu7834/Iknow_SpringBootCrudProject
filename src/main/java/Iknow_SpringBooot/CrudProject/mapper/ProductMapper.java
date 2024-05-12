package Iknow_SpringBooot.CrudProject.mapper;

import Iknow_SpringBooot.CrudProject.dto.ProductDto;
import Iknow_SpringBooot.CrudProject.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productToProductDto (Product product);

    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> productDtosToProducts(List<Product> productList);

    List<Product> productsToProductDtos(List<ProductDto> productDtoList);
}
