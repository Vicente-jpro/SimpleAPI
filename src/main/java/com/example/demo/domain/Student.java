package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity	
@Getter
@Setter
@ToString
public class Student implements Serializable{

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(nullable = false, updatable = false)
	 private Long id ;
	
	 private String name;
	 @Column(name = "phone_number")
	 private String phoneNumber;
	 
	 public Student() {
		 
	 }

	public Student(String name, String phoneNumber) {
		super();
		this.name = name.trim();
		this.phoneNumber = phoneNumber.trim();
	}

	public Student(Long id, String name, String phoneNumber) {
		super();
		this.id = id;
		this.name = name.trim();
		this.phoneNumber = phoneNumber.trim();
	}
	
	 
}
