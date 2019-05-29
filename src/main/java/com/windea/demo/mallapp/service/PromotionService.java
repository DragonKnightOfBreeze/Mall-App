package com.windea.demo.mallapp.service;

import com.windea.demo.mallapp.domain.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PromotionService {
	Promotion insert(Promotion promotion);

	void deleteById(Integer id);

	Promotion update(Promotion promotion);

	Promotion findById(Integer id);

	Page<Promotion> findAll(Pageable pageable);
}
