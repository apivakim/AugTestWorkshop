package com.aug.entities.va;

import com.aug.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "VA")
public class Va extends BaseEntity implements Serializable {
	
	@Column(name="EMAIL")
	private String email;
	@Column(name="AGE")
	private Integer age;
	@Column(name="VA")
	private String va;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getVa() {
		return va;
	}
	public void setVa(String va) {
		this.va = va;
	}
	
	
}
