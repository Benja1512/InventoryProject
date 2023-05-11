package com.example.InventoryProject.services;

import com.example.InventoryProject.inventory.dao.Category.ICategoryDao;
import com.example.InventoryProject.model.Category;
import com.example.InventoryProject.response.CategoryResponse;
import com.example.InventoryProject.response.CategoryResponseRest;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryDao categoryDao;


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {

        CategoryResponseRest response = new CategoryResponseRest();

        /*Seccion 2 Obtener categorias por Id */
        List<Category>  list = new ArrayList<>();

        try {
            List<Category> category = (List<Category>) categoryDao.findAll();

            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

        } catch (Exception e){

            response.setMetadata("Respuesta ok", "-1", "Error al consultar por id");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }



    /*Seccion 2 Obtener categorias por Id */
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id){

        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            Optional<Category> category = categoryDao.findById(id);

            if (category.isPresent()) {
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
            } else {
                response.setMetadata("Respuesta nok", "-1", "Categoria no Encontrada");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        }   catch (Exception e){

                response.setMetadata("Respuesta ok", "-1", "Error al consultar por id");
                e.getStackTrace();
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);

        }


    /*Seccion 3 Obtener categorias por Id - SAVE  */
    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> save(Category category) {

        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            Category categorySaved = categoryDao.save(category);

            if(categorySaved != null ){
                list.add(categorySaved);
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Respuesta ok", "-1", "Categoria no guardada");
            } else {
                response.setMetadata("Respuesta nok", "-1", "Categoria no guardada");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
            }

        }   catch (Exception e){

            response.setMetadata("Respuesta ok", "-1", "Error al grabar categoria");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);

    }
    }



