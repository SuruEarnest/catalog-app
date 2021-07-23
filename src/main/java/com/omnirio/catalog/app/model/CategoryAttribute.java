package com.omnirio.catalog.app.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category_attributes")
public class CategoryAttribute extends BaseEntity implements Serializable {

    @ApiModelProperty(value="id",name="id",required=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(value="name",name="name",required=true)
    @NotBlank(message = "Attribute name is required.")
    @Column(name="attribute_name")
    private String name;

    @ApiModelProperty(value="name",name="name",required=true)
    @NotBlank(message = "Attribute value is required.")
    @Column(name="attribute_value")
    private String value;
}
