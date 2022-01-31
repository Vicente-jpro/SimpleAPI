package com.example.demo.enums;

public enum HttpMessageEnum {

	CREATED("Successfully created"),
	RETRIVED("Successfully retrieved"),
	UPDATED("Successfully updated"),
	DELETED("Successfully deleted");
	
	public final String name;
	
	private HttpMessageEnum(String name ) {
		this.name = name;
	}
}
