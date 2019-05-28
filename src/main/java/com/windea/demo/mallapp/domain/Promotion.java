package com.windea.demo.mallapp.domain;

import com.windea.commons.base.template.TBean;

import javax.persistence.*;

/**
 * 推荐位广告的实体类。
 */
public class Promotion extends TBean<Integer> {
	private static final long serialVersionUID = 7317814456413346531L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer page;

	private String summary;

	private String imgUrl;

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
