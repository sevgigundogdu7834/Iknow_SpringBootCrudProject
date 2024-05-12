package Iknow_SpringBooot.CrudProject.dto;

import Iknow_SpringBooot.CrudProject.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String categoryName;
    private List<Product> productList;
}
