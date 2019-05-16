package com.windea.demo.mallapp.domain;

import com.windea.commons.base.template.TBean;

import javax.persistence.*;

@Entity
public class GuidePage extends TBean<Integer> {
	private static final long serialVersionUID = -7368884502990277436L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String adTitle;
	private String adLeft;
	private String adRight;
	private Integer page;
	private String imgUrl;


	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdLeft() {
		return adLeft;
	}

	public void setAdLeft(String adLeft) {
		this.adLeft = adLeft;
	}

	public String getAdRight() {
		return adRight;
	}

	public void setAdRight(String adRight) {
		this.adRight = adRight;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
