package com.product_service.client.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class ProductResponse {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
