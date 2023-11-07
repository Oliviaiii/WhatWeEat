package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer memberid;
	
	private String account;
	

}
