package com.example.InventoryProject.controller;


import com.example.InventoryProject.model.Category;
import com.example.InventoryProject.response.CategoryResponseRest;
import com.example.InventoryProject.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service;

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {

        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;

    }

    /*Seccion 2 Obtener categorias por Id */
    /*
    * get categories by id
    * @param id
    * @return
    */

    @GetMapping("/categories/{id}")

    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id) {

        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;

    }


    /*Seccion 3 Obtener categorias por Id - SAVE  */
    /*
     * save categories by id
     * @param id
     * @return
     */

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category) {

        ResponseEntity<CategoryResponseRest> response = service.save(category);
        return response;

    }
}