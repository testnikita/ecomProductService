package com.example.ecomproductservice.controllers;

import com.example.ecomproductservice.ThirdPartyProductClients.productService.FakeStore.FakeStoerProductServiceClient;
import com.example.ecomproductservice.dtos.GenericProductDTO;
import com.example.ecomproductservice.exceptions.NotFoundException;
import com.example.ecomproductservice.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;
    @Autowired
    private FakeStoerProductServiceClient fakeStoerProductServiceClient;

    @Test
    void throwExceptionWhenNoProductFound() throws NotFoundException {
        when(productService.getProductById(any(Long.class))).thenReturn(null);

        assertThrows(NotFoundException.class,()->productController.getProductById(121L));
    }
//    @Test
//    void testReturnsNullWhenProductDoesntExits() throws NotFoundException {
//        GenericProductDTO genericProductDTO = productController.getProductById(101L);
//        when(
//                productService.getProductById(any(Long.class)
//                )).thenReturn(null);
//        assertNull(genericProductDTO);
//    }
    @Test
    @DisplayName("No ProductFound")
    void testOnePlusEqualOneTrue() throws NotFoundException {
        //assertNull(fakeStoerProductServiceClient.getProductById(101L));
        assertThrows(NotFoundException.class,()->fakeStoerProductServiceClient.getProductById(101L));
    }

    void additionShouldBeCorrect()
    {
//        assertTrue(-1+-1==-2,"adding 2 negative result in negative");
//        assert  1+0==1;
//        assert 1+1==2;
    }

}
