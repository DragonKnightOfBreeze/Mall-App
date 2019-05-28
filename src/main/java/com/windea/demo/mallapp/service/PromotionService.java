package com.windea.demo.mallapp.service;

import com.windea.demo.mallapp.domain.Promotion;

public interface PromotionService {
	Promotion insert(Promotion promotion);

	void deleteById(Integer id);

	Promotion update(Promotion promotion);

	Promotion findById(Integer id);
}
