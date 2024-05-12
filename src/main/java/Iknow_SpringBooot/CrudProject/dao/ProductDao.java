package Iknow_SpringBooot.CrudProject.dao;

import Iknow_SpringBooot.CrudProject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> findByCategory_Id(Long  categoryId);

}
