package com.omnirio.catalog.app.api;

import com.omnirio.catalog.app.exceptions.BadRequestException;
import com.omnirio.catalog.app.exceptions.CustomResponse;
import com.omnirio.catalog.app.model.Product;
import com.omnirio.catalog.app.service.ProductService;
import com.omnirio.catalog.app.utils.ErrorResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Api(tags = "Products Management Endpoints ", description = "Endpoints for to manage products", hidden = false, produces = "application/json")
public class ProductApi {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/v1/products",consumes="application/json",produces="application/json")
	@ApiOperation(value = "Create Product", notes = "creates a new product on the product catalogs.")
	public @ResponseBody
	ResponseEntity<?> createProduct(@RequestBody @Validated Product product, BindingResult result) {

		if (result.hasErrors()) {
			throw new BadRequestException("" + ErrorResponseManager.getErrorMessages(result));
		}
        Product customerRecord = productService.create(product);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
				.withCode("201")
				.withMessage("product saved successfully.")
				.withTimestamp(new Date())
				.withData(customerRecord)
				.withStatus(HttpStatus.CREATED).build();
		return new ResponseEntity<>(responseBody, responseBody.getStatus());
	}

	@PutMapping(value="/v1/products",consumes="application/json",produces="application/json")
	@ApiOperation(value = "Update Product", notes = "update an existing product on the product catalogs.")
	public @ResponseBody
	ResponseEntity<?> updateProduct(@RequestBody @Validated Product product, BindingResult result) {

		if (result.hasErrors()) {
			throw new BadRequestException("" + ErrorResponseManager.getErrorMessages(result));
		}
		Product customerRecord = productService.update(product);
		CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
				.withCode("200")
				.withMessage("product saved successfully.")
				.withTimestamp(new Date())
				.withData(customerRecord)
				.withStatus(HttpStatus.OK).build();
		return new ResponseEntity<>(responseBody, responseBody.getStatus());
	}
	
	@GetMapping(value="/v1/products",produces="application/json")
	@ApiOperation(value = "Get All Products", notes = "gets all products in the catalog.")
	public @ResponseBody
	ResponseEntity<?> getAllProducts(@RequestParam("page") int page,  @RequestParam("size") int size) {

        Page<Product> products = productService.findAll(page, size);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
				.withCode("200")
				.withMessage(products.getContent().isEmpty()? "No records found": "product details fetched successfully.")
				.withTimestamp(new Date())
				.withData(products.getContent())
				.withStatus(HttpStatus.OK).build();
		return new ResponseEntity<>(responseBody, responseBody.getStatus());

	}

	@GetMapping(value="/v1/products/{id}",produces="application/json")
	@ApiOperation(value = "Get Products", notes = "gets all products in the catalog.")
	public @ResponseBody
	ResponseEntity<?> getProductById(@PathVariable("id") long id) {

		Product product = productService.findById(id);
		CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
				.withCode("200")
				.withMessage(product!=null ? "Product not found": "product details fetched successfully.")
				.withTimestamp(new Date())
				.withData(product)
				.withStatus(HttpStatus.OK).build();
		return new ResponseEntity<>(responseBody, responseBody.getStatus());

	}
	

}
