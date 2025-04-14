package com.app.categorymicroservice.Service;

import com.app.categorymicroservice.DTO.SalonDTO;
import com.app.categorymicroservice.Modal.Category;

import java.util.Set;

public interface CategoryService {

    Category save(Category category, SalonDTO salonDTO);

    Set<Category> getCategoriesBySalonId(Long salonId);

    Category getCategoryById(Long categoryId) throws Exception;

    void deleteCategoryById(Long categoryId,Long salonId) throws Exception;
}
