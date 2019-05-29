package com.windea.demo.mallapp.repository;


import com.windea.demo.mallapp.domain.GuidePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuidePageRepository extends JpaRepository<GuidePage, Integer> {
	Page<GuidePage> findAllByOrderByPageAsc(Pageable pageable);

	Page<GuidePage> findAllByAdTitleContainsOrAdLeftContainsOrAdRightContainsOrderByPageAsc(
		String title, String adLeft, String adRight, Pageable pageable
	);
}
