package com.example.demo.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Message {
	private int id;
	private int user_id;
	private String text;
	private Date created_date;
	private Date updated_date;

}
