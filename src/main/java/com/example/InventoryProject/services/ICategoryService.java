package com.example.InventoryProject.services;

import com.example.InventoryProject.response.CategoryResponse;
import com.example.InventoryProject.response.CategoryResponseRest;
import jdk.jfr.Category;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    public ResponseEntity<CategoryResponseRest> search ();
}
