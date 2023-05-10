package com.example.InventoryProject.response;


import com.example.InventoryProject.model.Category;
import lombok.Data;

import java.util.List;

@Data /* @Data es metoto Lombok y crea metodos getter and setter */
public class CategoryResponse {

    private List<Category> category;

}
