package Iknow_SpringBooot.CrudProject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private CategoryDto category;
    private String productName;
    private double unitPrice;
    private short unitsInStock;
    private String quantityPerUnit;
}
