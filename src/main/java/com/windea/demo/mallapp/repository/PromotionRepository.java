package com.windea.demo.mallapp.repository;

import com.windea.demo.mallapp.domain.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
	Page<Promotion> findAllByOrderByPageAsc(Pageable pageable);
}
