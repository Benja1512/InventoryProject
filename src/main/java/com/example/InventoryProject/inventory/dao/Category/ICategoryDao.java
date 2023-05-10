package com.example.InventoryProject.inventory.dao.Category;


import com.example.InventoryProject.model.Category;
import org.springframework.data.repository.CrudRepository;


public interface ICategoryDao extends CrudRepository<Category, Long> {
}
