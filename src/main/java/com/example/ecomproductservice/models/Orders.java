package com.example.ecomproductservice.models;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Orders extends BaseModel{
    @ManyToOne
    private List<Product> product;
}
