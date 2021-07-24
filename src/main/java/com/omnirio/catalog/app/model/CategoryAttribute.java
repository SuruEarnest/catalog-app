package com.omnirio.catalog.app.model;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category_attributes")
public class CategoryAttribute extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Attribute name is required.")
    @Column(name="attribute_name")
    private String categoryAttributeName;

    @NotEmpty(message = "Attribute value is required.")
    @Column(name="attribute_value")
    private String categoryAttributeValue;
}
