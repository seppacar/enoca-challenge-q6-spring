package com.enoca.backend_challenge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseModel{
    private String name;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
