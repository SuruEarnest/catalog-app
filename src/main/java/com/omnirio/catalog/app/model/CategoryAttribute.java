package com.omnirio.catalog.app.model;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category_attributes")
public class CategoryAttribute extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryAttributeId;

    @NotBlank(message = "Attribute name is required.")
    @Column(name="attribute_name")
    private String categoryAttributeName;

    @NotBlank(message = "Attribute value is required.")
    @Column(name="attribute_value")
    private String categoryAttributeValue;
}
