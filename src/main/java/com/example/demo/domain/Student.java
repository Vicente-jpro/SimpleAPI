package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity	
@Getter
@Setter
public class Student {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id ;
	
	 private String name;
	 @Column(name = "phone_number")
	 private String phoneNumber;
	 
	 public Student() {
		 
	 }

	public Student(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Student(Long id, String name, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	 
}
