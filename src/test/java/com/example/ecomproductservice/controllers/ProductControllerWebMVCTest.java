package com.example.ecomproductservice.controllers;

import com.example.ecomproductservice.dtos.GenericProductDTO;
import com.example.ecomproductservice.exceptions.NotFoundException;
import com.example.ecomproductservice.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//Class to test json response will be used by Client
//WebMVCTest only intialize repository,service,controllers needed for the class
//@WebMvcTest(ProductController.class) - intialize dependencies specific to product controller
@WebMvcTest(ProductController.class)
public class ProductControllerWebMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductController productController;

    @Autowired
    private ObjectMapper objectMapper;
    @Captor
    private ArgumentCaptor<Long>idCaptor;

    @Test
    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception {

        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
        .andExpect(content().string("[]"));
    }
    @Test
    void returnsListOfProductWhenProductsExist() throws Exception {
        ArrayList<GenericProductDTO> productDTOS = new ArrayList<>();
        productDTOS.add(new GenericProductDTO());
        productDTOS.add(new GenericProductDTO());
        productDTOS.add(new GenericProductDTO());
        //to check json have a particular field use jsonpath
        when(productService.getAllProducts()).thenReturn(productDTOS);
        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(productDTOS)))
                .andExpect(jsonPath("$.student.name",is("Nikita")))
                .andExpect((jsonPath("$.length()",is(2))));
    }
    @Test
    void createProductShouldCreateNewProduct() throws Exception {

        GenericProductDTO productToCreate = new GenericProductDTO();
        productToCreate.setDescription("iphone");
        productToCreate.setTitle("mobile");
        productToCreate.setImage("image");
        productToCreate.setCategory("mobile phones");

        GenericProductDTO expectedProduct = new GenericProductDTO();
        expectedProduct.setId(1001L);
        expectedProduct.setDescription("iphone");
        expectedProduct.setTitle("mobile");
        expectedProduct.setImage("image");
        expectedProduct.setCategory("mobile phones");


        when(productService.createProduct(any())).thenReturn(expectedProduct);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(productToCreate))
                        )
                .andExpect(content().string(objectMapper.writeValueAsString(expectedProduct)));

    }

    @Test
    void productControllerCallsProductServiceWithSameProductId() throws NotFoundException {
        Long id = 101L;
        when(productService.getProductById(id))
                .thenReturn(new GenericProductDTO());

        productController.getProductById(id);
        verify(productService.getProductById(idCaptor.capture()));
        assertEquals(id,idCaptor.getValue());
    }


}
