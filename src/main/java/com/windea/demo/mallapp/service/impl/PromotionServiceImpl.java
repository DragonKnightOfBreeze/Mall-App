package com.windea.demo.mallapp.service.impl;

import com.windea.demo.mallapp.domain.Promotion;
import com.windea.demo.mallapp.repository.PromotionRepository;
import com.windea.demo.mallapp.service.PromotionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
	private final PromotionRepository repository;

	public PromotionServiceImpl(PromotionRepository repository) {
		this.repository = repository;
	}


	@Override
	public Promotion insert(Promotion promotion) {
		var result = repository.save(promotion);
		return result;
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Promotion update(Promotion promotion) {
		var origin = findById(promotion.getId());
		if(origin != null) {
			repository.save(promotion);
		}
		return promotion;
	}

	@Override
	public Promotion findById(Integer id) {
		var result = repository.findById(id).orElse(null);
		return result;
	}

	@Override
	public List<Promotion> findAll() {
		var resultList = repository.findAllByOrderByPageAsc();
		return resultList;
	}
}
