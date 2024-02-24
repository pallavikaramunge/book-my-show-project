package com.example.exception;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private Integer fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public ResourceNotFoundException(String msg) {
		
		super(msg);
	}
	
}
