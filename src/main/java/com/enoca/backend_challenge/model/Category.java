package com.enoca.backend_challenge.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
