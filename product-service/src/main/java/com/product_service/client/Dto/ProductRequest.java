package com.product_service.client.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {

    @JsonAlias("id")
    @JsonProperty("id")
    private Integer id;

    @JsonAlias("title")
    @JsonProperty("title")
    private String title;

    @JsonAlias("price")
    @JsonProperty("price")
    private Float price;

    @JsonAlias("description")
    @JsonProperty("description")
    private String description;

    @JsonAlias("category")
    @JsonProperty("category")
    private String category;

    @JsonAlias("image")
    @JsonProperty("image")
    private String image;
}
