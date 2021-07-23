package com.omnirio.catalog.app.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "category name is required.")
    @Column(name="category_name",unique=true)
    private String categoryName;

    @NotBlank(message = "category attribute is required.")
    @NotEmpty(message="category attributes cannot be empty")
    @JoinColumn(name="category_attribute",unique=true)
    @OneToMany
    private List<CategoryAttribute> categoryAttributes;
}
