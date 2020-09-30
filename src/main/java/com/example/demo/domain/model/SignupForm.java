package com.example.demo.domain.model;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {

	//private Integer id;

	@NotBlank(groups = ValidGroup1.class)
	@Length(max = 20, groups = ValidGroup2.class)
	private String name;

	@NotBlank(groups = ValidGroup1.class)
	@Length(max = 20, groups = ValidGroup2.class)
	private String account;

	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 4, max = 100, groups = ValidGroup2.class)
	@Pattern(regexp="^[a-zA-Z0-9]+$", groups = ValidGroup3.class)
	private String password;

	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String email;
	private String description;
	//private Date created_at;
	//private Date updated_at;

}
