package com.windea.demo.mallapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.windea.commons.base.template.TBean;

import javax.persistence.*;

@Entity
public class Product extends TBean<Integer> {
	private static final long serialVersionUID = 2813500562225969128L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@OneToOne(mappedBy = "product")
	private HomePageAd homePageAd;


	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
