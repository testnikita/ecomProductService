package com.example.ecomproductservice.controllers;

import com.example.ecomproductservice.dtos.GetProductTitleRequestDTO;
import com.example.ecomproductservice.dtos.ProductDTO;
import com.example.ecomproductservice.models.Category;
import com.example.ecomproductservice.models.Product;
import com.example.ecomproductservice.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }
    @GetMapping("/{uuid}")
    public List<ProductDTO> getCategory(@PathVariable("uuid") String uuid)
    {
        List<Product> products = categoryService.getCategory(uuid).getProducts();
        List<ProductDTO> lstProductDTO = new ArrayList<>();

        for(Product product : products)
        {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setDescription(product.getDescription());
            productDTO.setImage(product.getImage());
            productDTO.setPrice(product.getPrice());
            productDTO.setTitle(product.getTitle());
            lstProductDTO.add(productDTO);

        }
        return lstProductDTO;
    }

    @GetMapping("/titles/")
    public List<String> getProductTitles(@RequestBody GetProductTitleRequestDTO requestDTO)
    {
        List<String> uuids = requestDTO.getUuids();
        return categoryService.getProductTitles(uuids);
    }
}
