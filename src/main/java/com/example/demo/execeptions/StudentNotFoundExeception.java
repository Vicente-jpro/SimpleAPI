package com.example.demo.execeptions;

public class StudentNotFoundExeception extends RuntimeException {
	
	public StudentNotFoundExeception (String message) {
		super(message);
	}

}
