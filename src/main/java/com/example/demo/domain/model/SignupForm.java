package com.example.demo.domain.model;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {

	//private Integer id;

	@NotBlank
	private String name;

	@NotBlank
	private String account;

	@NotBlank
	@Length(min = 4, max = 100)
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;

	@NotBlank
	@Email
	private String email;
	private String description;
	//private Date created_at;
	//private Date updated_at;

}
