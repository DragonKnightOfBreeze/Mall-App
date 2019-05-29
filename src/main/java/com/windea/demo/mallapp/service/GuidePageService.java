package com.windea.demo.mallapp.service;

import com.windea.demo.mallapp.domain.GuidePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GuidePageService {
	GuidePage insert(GuidePage guidePage);

	void deleteById(Integer id);

	GuidePage update(GuidePage guidePage);

	GuidePage findById(Integer id);

	Page<GuidePage> findAll(Pageable pageable);

	Page<GuidePage> findAllByConditions(String adTitle, String adLeft, String adRight,Pageable pageable);
}
