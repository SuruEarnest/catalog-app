package com.omnirio.catalog.app.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity implements Serializable {
	
	@ApiModelProperty(value="id",name="id",required=false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
   
	@ApiModelProperty(value="name",name="name",required=true)
	@NotBlank(message = "Product name is required.")
	@Column(name="product_name")
	private String name;
   
	@ApiModelProperty(value="email",name="email",required=true)
	@NotBlank(message = "category Id is required.")
	@OneToOne
	@JoinColumn(name="category",unique=true)
	private Category category;

}
