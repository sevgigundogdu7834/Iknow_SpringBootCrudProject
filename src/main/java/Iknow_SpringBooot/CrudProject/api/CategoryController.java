package Iknow_SpringBooot.CrudProject.api;

import Iknow_SpringBooot.CrudProject.dto.CategoryDto;
import Iknow_SpringBooot.CrudProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategory = categoryService.create(categoryDto);
        return new ResponseEntity<CategoryDto>(savedCategory, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categoryDtos=categoryService.getAll();
        return new ResponseEntity<List<CategoryDto>>(categoryDtos, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(name = "id") Long categoryId){
        CategoryDto categoryDto = categoryService.getById(categoryId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategoryById(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategoryDto = categoryService.update(id,categoryDto);
        return new ResponseEntity<CategoryDto>(updatedCategoryDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable(name = "id") Long categoryId){
        categoryService.delete(categoryId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll(){
        categoryService.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.OK);

    }
}
