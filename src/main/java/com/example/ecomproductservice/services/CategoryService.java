package com.example.ecomproductservice.services;

import com.example.ecomproductservice.models.Category;

import java.util.List;

public interface CategoryService {

    Category getCategory(String uuid);

    List<String> getProductTitles(List<String> categoryUUIDs);
}
