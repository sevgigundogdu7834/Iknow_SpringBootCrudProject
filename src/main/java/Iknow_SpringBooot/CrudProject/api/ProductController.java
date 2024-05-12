package Iknow_SpringBooot.CrudProject.api;

import Iknow_SpringBooot.CrudProject.dao.CategoryDao;
import Iknow_SpringBooot.CrudProject.dao.ProductDao;
import Iknow_SpringBooot.CrudProject.dto.ProductDto;
import Iknow_SpringBooot.CrudProject.entity.Product;
import Iknow_SpringBooot.CrudProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;


    @PostMapping("/create")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        ProductDto savedProduct = productService.create(productDto);
        return new ResponseEntity<ProductDto>(savedProduct, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos=productService.getAll();
        return new ResponseEntity<List<ProductDto>>(productDtos, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") Long productId){
        ProductDto productDto = productService.getById(productId);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        ProductDto updatedProductDto = productService.update(id,productDto);
        return new ResponseEntity<ProductDto>(updatedProductDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable(name = "id") Long productId){
        productService.delete(productId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllProducts(){
        productService.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @GetMapping("/getProductListByCategory/{categoryId}")
    public ResponseEntity<List<Product>> getProductListByCategory(@PathVariable Long categoryId){
        List<Product> productDtos= productService.getProductsByCategoryId(categoryId);
        return new ResponseEntity<List<Product>>(productDtos, HttpStatus.OK);

    }

}
