package com.windea.demo.mallapp.service;

import com.windea.demo.mallapp.domain.GuidePage;

import java.util.List;

public interface GuidePageService {
	GuidePage insert(GuidePage guidePage);

	void deleteById(Integer id);

	GuidePage update(GuidePage guidePage);

	GuidePage findById(Integer id);

	List<GuidePage> findByConditions(String adTitle, String adLeft, String adRight);
}
