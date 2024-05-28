package com.example.ecomproductservice.ThirdPartyProductClients.productService.FakeStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeStoerProductServiceClientTest {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Test
    void testNonExistingProductReturnsNull()
    {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreDTO> response = restTemplate.getForEntity(URL, FakeStoreDTO.class,id);
//
//        FakeStoreDTO fakeStoreDTO = response.getBody();
//        assertNull(fakeStoreDTO);
    }


}