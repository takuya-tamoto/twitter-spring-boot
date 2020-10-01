package com.example.demo.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {

	private int id;
	private String name;
	private String account;
	private String password;
	private String email;
	private String description;
	private Date created_date;
	private Date updated_date;

}
