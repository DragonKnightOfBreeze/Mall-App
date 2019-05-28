package com.windea.demo.mallapp.repository;

import com.windea.demo.mallapp.domain.HomePageAd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomePageAdRepository extends JpaRepository<HomePageAd, Integer> {
	List<HomePageAd> findAllByOrderByCategoryAscPageAsc();
}
