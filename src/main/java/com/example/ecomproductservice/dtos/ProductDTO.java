package com.example.ecomproductservice.dtos;

import com.example.ecomproductservice.models.Category;
import com.example.ecomproductservice.models.Price;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private String title;
    private String description;
    private double price;
    private String image;
    private Price itemPrice;
}
