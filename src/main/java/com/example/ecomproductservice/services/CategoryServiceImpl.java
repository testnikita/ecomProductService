package com.example.ecomproductservice.services;

import com.example.ecomproductservice.models.Category;
import com.example.ecomproductservice.models.Product;
import com.example.ecomproductservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category getCategory(String uuid) {
       Optional<Category>categoryOptional = categoryRepository.findById(UUID.fromString(uuid));
        if(categoryOptional.isEmpty())
        {
            return null;
        }
        Category category = categoryOptional.get();
        List<Product> products = category.getProducts();

        return category;
    }

    public List<String> getProductTitles(List<String> categoryUUIDs)
    {

        List<UUID> uuids = new ArrayList<>();

        for(String uuid:categoryUUIDs)
        {
            uuids.add(UUID.fromString(uuid));
        }
        List<Category>categoryOptional = categoryRepository.findAllById(uuids);

        List<String> titles = new ArrayList<>();

        categoryOptional.forEach(
                category ->{
                    category.getProducts().forEach(
                            product -> {
                                titles.add(product.getTitle());
                            }
                    );
                }
        );
        return titles;
    }
}
