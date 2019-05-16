package com.windea.demo.mallapp.repository;


import com.windea.demo.mallapp.domain.GuidePage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuidePageRepository extends JpaRepository<GuidePage, Integer> {
	void deleteById(Integer id);

	List<GuidePage> findAllByAdTitleLikeOrAdLeftLikeOrAdRightLike(String title, String adLeft, String adRight);
}
