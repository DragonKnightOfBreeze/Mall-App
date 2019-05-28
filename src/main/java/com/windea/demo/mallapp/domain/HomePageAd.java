package com.windea.demo.mallapp.domain;

import com.windea.commons.base.template.TBean;
import com.windea.demo.mallapp.enums.AdCategory;

import javax.persistence.*;

/**
 * 首页广告的实体类。
 */
@Entity
public class HomePageAd extends TBean<Integer> {
	private static final long serialVersionUID = 2831605470872445205L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private AdCategory category;

	private Integer page;

	private String summary;

	private String imgUrl;

	@OneToOne
	private Product product;


	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AdCategory getCategory() {
		return category;
	}

	public void setCategory(AdCategory category) {
		this.category = category;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
