package com.omnirio.catalog.app.api;

import com.omnirio.catalog.app.exceptions.BadRequestException;
import com.omnirio.catalog.app.exceptions.CustomResponse;
import com.omnirio.catalog.app.model.CategoryAttribute;
import com.omnirio.catalog.app.service.CategoryAttributeService;
import com.omnirio.catalog.app.utils.ErrorResponseManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Api(tags = "Category Attribute Management Endpoints ", description = "Endpoints to manage category attribute endpoints", hidden = false, produces = "application/json")
public class CategoryAttributeApi {

    @Autowired
    private CategoryAttributeService categoryAttributeService;

    @PostMapping(value="/v1/category-attributes",consumes="application/json",produces="application/json")
    @ApiOperation(value = "Create Category Attribute", notes = "creates a new category on the product catalogs.")
    public @ResponseBody
    ResponseEntity<?> createProduct(@RequestBody @Validated CategoryAttribute categoryAttribute, BindingResult result) {

        if (result.hasErrors()) {
            throw new BadRequestException("" + ErrorResponseManager.getErrorMessages(result));
        }
        CategoryAttribute createdCategoryAttrribute = categoryAttributeService.save(categoryAttribute);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
                .withCode("201")
                .withMessage("category attribute saved successfully.")
                .withTimestamp(new Date())
                .withData(createdCategoryAttrribute)
                .withStatus(HttpStatus.CREATED).build();
        return new ResponseEntity<>(responseBody, responseBody.getStatus());
    }

    @PutMapping(value="/v1/category-attributes",consumes="application/json",produces="application/json")
    @ApiOperation(value = "Update Category", notes = "update an existing category on the product catalogs.")
    public @ResponseBody
    ResponseEntity<?> updateProduct(@RequestBody @Validated CategoryAttribute categoryAttribute, BindingResult result) {

        if (result.hasErrors()) {
            throw new BadRequestException("" + ErrorResponseManager.getErrorMessages(result));
        }
        CategoryAttribute updatedCategoryAttribute = categoryAttributeService.save(categoryAttribute);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
                .withCode("200")
                .withMessage("category updated successfully.")
                .withTimestamp(new Date())
                .withData(updatedCategoryAttribute)
                .withStatus(HttpStatus.OK).build();
        return new ResponseEntity<>(responseBody, responseBody.getStatus());
    }

    @GetMapping(value="/v1/category-attributes",consumes="application/json",produces="application/json")
    @ApiOperation(value = "Get Categories", notes = "gets all products categories in the catalog.")
    public @ResponseBody
    ResponseEntity<?> getProduct(@RequestParam("page") int page,  @RequestParam("size") int size) {

        Page<CategoryAttribute> categories = categoryAttributeService.findAll(page, size);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
                .withCode("200")
                .withMessage(categories.getContent().isEmpty()? "No records found": "category attribute details fetched successfully.")
                .withTimestamp(new Date())
                .withData(categories)
                .withStatus(HttpStatus.OK).build();
        return new ResponseEntity<>(responseBody, responseBody.getStatus());

    }

}
