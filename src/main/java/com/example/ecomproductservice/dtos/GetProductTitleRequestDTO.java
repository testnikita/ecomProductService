package com.example.ecomproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetProductTitleRequestDTO {

    private List<String> uuids;

}
