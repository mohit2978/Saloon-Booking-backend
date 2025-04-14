package com.app.categorymicroservice.Controller;

import com.app.categorymicroservice.DTO.SalonDTO;
import com.app.categorymicroservice.Modal.Category;
import com.app.categorymicroservice.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {

    private final CategoryService categoryService;

    @PostMapping("/{id}")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        SalonDTO salonDTO=new SalonDTO();
        salonDTO.setId(1L);
        Category category1=categoryService.save(category,salonDTO);
        return ResponseEntity.ok(category1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {
        SalonDTO salonDTO=new SalonDTO();
        salonDTO.setId(1L);
        categoryService.deleteCategoryById(id, salonDTO.getId());
        return ResponseEntity.ok("category deleted successfully");
    }


}
