package com.omnirio.catalog.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Date createdDate;

    @JsonIgnore
    private Date lastModifiedDate;

    @JsonIgnore
    private boolean deletionStatus;

}
