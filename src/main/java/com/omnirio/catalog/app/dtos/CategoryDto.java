package com.omnirio.catalog.app.dtos;

import com.omnirio.catalog.app.model.CategoryAttribute;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

public class CategoryDto {

    @ApiModelProperty(value="id",name="id",required=false)
    private long categoryId;

    @ApiModelProperty(value="categoryName",name="categoryName",required=true)
    @NotBlank(message = "Category Name is required.")
    private String categoryName;

    @ApiModelProperty(value="email",name="email",required=true)
    @NotBlank(message = "Email address is required.")
    private ArrayList<CategoryAttribute> productCategoryAttributes;
}
