package com.omnirio.catalog.app.api;

import com.omnirio.catalog.app.exceptions.BadRequestException;
import com.omnirio.catalog.app.exceptions.CustomResponse;
import com.omnirio.catalog.app.model.Category;
import com.omnirio.catalog.app.model.CategoryAttribute;
import com.omnirio.catalog.app.service.CategoryService;
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
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Api(tags = "Category Management Endpoints ", description = "Endpoints for to manage product categories", hidden = false, produces = "application/json")
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value="/v1/categories",consumes="application/json",produces="application/json")
    @ApiOperation(value = "Create Category", notes = "creates a new category on the product catalogs.")
    public @ResponseBody
    ResponseEntity<?> createCategory(@RequestBody @Validated Category category, BindingResult result) {

        if (result.hasErrors()) {
            throw new BadRequestException("" + ErrorResponseManager.getErrorMessages(result));
        }
        Category createdCategory = categoryService.create(category);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
                .withCode("201")
                .withMessage("category saved successfully.")
                .withTimestamp(new Date())
                .withData(createdCategory)
                .withStatus(HttpStatus.CREATED).build();
        return new ResponseEntity<>(responseBody, responseBody.getStatus());
    }

    @PutMapping(value="/v1/categories",consumes="application/json",produces="application/json")
    @ApiOperation(value = "Update Category", notes = "update an existing category on the product catalogs.")
    public @ResponseBody
    ResponseEntity<?> updateCategory(@RequestBody @Validated Category category, BindingResult result) {

        if (result.hasErrors()) {
            throw new BadRequestException("" + ErrorResponseManager.getErrorMessages(result));
        }
        Category updatedCategory = categoryService.update(category);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
                .withCode("200")
                .withMessage("category updated successfully.")
                .withTimestamp(new Date())
                .withData(updatedCategory)
                .withStatus(HttpStatus.OK).build();
        return new ResponseEntity<>(responseBody, responseBody.getStatus());
    }

    @GetMapping(value="/v1/categories",produces="application/json")
    @ApiOperation(value = "Get Categories", notes = "gets all products categories in the catalog.")
    public @ResponseBody
    ResponseEntity<?> getCategories(@RequestParam("page") int page,  @RequestParam("size") int size) {

        Page<Category> categories = categoryService.findAll(page, size);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
                .withCode("200")
                .withMessage(categories.getContent().isEmpty()? "No records found": "category details fetched successfully.")
                .withTimestamp(new Date())
                .withData(categories)
                .withStatus(HttpStatus.OK).build();
        return new ResponseEntity<>(responseBody, responseBody.getStatus());

    }

    @GetMapping(value="/v1/categories/{id}",produces="application/json")
    @ApiOperation(value = "Get Categories", notes = "gets all products categories in the catalog.")
    public @ResponseBody
    ResponseEntity<?> getCategoryById(@PathVariable("id") long id) {

       Category category = categoryService.findById(id);
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
                .withCode("200")
                .withMessage(category==null ? "No record found": "category details fetched successfully.")
                .withTimestamp(new Date())
                .withData(category)
                .withStatus(HttpStatus.OK).build();
        return new ResponseEntity<>(responseBody, responseBody.getStatus());
    }

    @GetMapping(value="/v1/category/{categoryId}/category-attributes",produces="application/json")
    @ApiOperation(value = "Get Attribute by CategoryID", notes = "gets category attributes by category id in the catalog.")
    public @ResponseBody
    ResponseEntity<?> getCategoryAttributesByCategoryId(@RequestParam("categoryId") long categoryId) {

        Category category = categoryService.findById(categoryId);
        List<CategoryAttribute> categoryAttributes = category.getCategoryAttributes();
        CustomResponse<?> responseBody = new CustomResponse.CustomResponseBuilder<>()
                .withCode("200")
                .withMessage(categoryAttributes.isEmpty() ? "No category attributes ": "category attribute details fetched successfully.")
                .withTimestamp(new Date())
                .withData(categoryAttributes)
                .withStatus(HttpStatus.OK).build();
        return new ResponseEntity<>(responseBody, responseBody.getStatus());

    }


}
