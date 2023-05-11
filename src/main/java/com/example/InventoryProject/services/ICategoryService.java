package com.example.InventoryProject.services;

import com.example.InventoryProject.model.Category;
import com.example.InventoryProject.response.CategoryResponse;
import com.example.InventoryProject.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {


    public ResponseEntity<CategoryResponseRest> search ();
    /*Seccion 2 Obtener categorias por Id */
    public ResponseEntity<CategoryResponseRest> searchById(Long id);
    /*Seccion 3 Obtener categorias por Id - SAVE  */
    public ResponseEntity<CategoryResponseRest> save(Category category);



}
