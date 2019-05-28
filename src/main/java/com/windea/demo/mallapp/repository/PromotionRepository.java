package com.windea.demo.mallapp.repository;

import com.windea.demo.mallapp.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
	List<Promotion> findAllByOrderByPageAsc();
}
