package com.myapp.fsd.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "newproducts")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String description;
   private boolean productAvailable;
   private Double starRating;
   private String  imageUrl;

    public Product() {
    }

    public Product( String name, Double price, String description, boolean productAvailable, Double starRating, String imageUrl) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.productAvailable = productAvailable;
        this.starRating = starRating;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    public Double getStarRating() {
        return starRating;
    }

    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return productAvailable == product.productAvailable && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(description, product.description) && Objects.equals(starRating, product.starRating) && Objects.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, productAvailable, starRating, imageUrl);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", productAvailable=" + productAvailable +
                ", starRating=" + starRating +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
