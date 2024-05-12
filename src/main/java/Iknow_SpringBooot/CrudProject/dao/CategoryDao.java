package Iknow_SpringBooot.CrudProject.dao;

import Iknow_SpringBooot.CrudProject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao  extends JpaRepository<Category,Integer> {
}
