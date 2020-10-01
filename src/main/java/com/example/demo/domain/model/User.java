package com.example.demo.domain.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component//Controlle部分に注入@Autowired
@Data
public class User implements Serializable {

	private int id;
	private String name;
	private String account;
	private String password;
	private String email;
	private String description;
	private Date created_date;
	private Date updated_date;

}
