package com.alas.task1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", allocationSize = 1)
    @Column(name = "id", unique = true)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product" , fetch = FetchType.LAZY)
    private ProductDetails productDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // This ensures cartsList is not included in the JSON response
    private List<ShoppingCarts> cartsList;
}
