package com.omnirio.catalog.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category extends BaseEntity implements Serializable {
    @ApiModelProperty(value="id",name="id",required=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(value="name",name="name",required=true)
    @NotBlank(message = "category Name is required.")
    @Column(name="category_name")
    private String name;

    @ApiModelProperty(value="categoryAttributes",name="categoryAttributes",required=true)
    @NotBlank(message = "category attribute is required.")
    @JoinColumn(name="category_attribute",unique=true)
    @OneToMany
    private List<CategoryAttribute> categoryAttributes;
}
