package com.app.categorymicroservice.Service.Impl;

import com.app.categorymicroservice.DTO.SalonDTO;
import com.app.categorymicroservice.Modal.Category;
import com.app.categorymicroservice.Repository.CategoryRepository;
import com.app.categorymicroservice.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category category, SalonDTO salonDTO) {
        Category cat=new Category();
        cat.setName(category.getName());
        cat.setSalonId(salonDTO.getId());
        cat.setImage(category.getImage());
        return categoryRepository.save(cat);
    }

    @Override
    public Set<Category> getCategoriesBySalonId(Long salonId) {
        return categoryRepository.findBySalonId(salonId);
    }

    @Override
    public Category getCategoryById(Long categoryId) throws Exception {
        Category cat=categoryRepository.findById(categoryId).orElse(null);
        if(cat==null) throw new Exception("Category not found with id "+categoryId);
        return cat;
    }

    @Override
    public void deleteCategoryById(Long categoryId,Long salonId) throws Exception {
        Category category= getCategoryById(categoryId);
        if(category.getSalonId()==salonId) categoryRepository.delete(category);
        else throw new Exception("Category's salon id "+category.getSalonId()+" does not match salon id "+salonId);
    }
}
