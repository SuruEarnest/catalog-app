package com.omnirio.catalog.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime createdDate;

    @JsonIgnore
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime lastModifiedDate;
}
