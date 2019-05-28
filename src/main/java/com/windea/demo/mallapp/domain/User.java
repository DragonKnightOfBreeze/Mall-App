package com.windea.demo.mallapp.domain;

import com.windea.commons.base.template.TBean;

import javax.persistence.*;

@Entity
public class User extends TBean<Integer> {
	private static final long serialVersionUID = -2952362979341904734L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String password;


	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
