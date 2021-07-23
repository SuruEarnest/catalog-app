package com.omnirio.catalog.app.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	@NotBlank(message = "Product name is required.")
	@Column(name="product_name")
	private String productName;

	@NotBlank(message = "category Id is required.")
	@OneToOne
	@JoinColumn(name="category",unique=true)
	private Category category;

}
