package com.windea.demo.mallapp.service.impl;

import com.windea.demo.mallapp.domain.Advert;
import com.windea.demo.mallapp.repository.HomePageAdRepository;
import com.windea.demo.mallapp.service.HomePageAdService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HomePageAdServiceImpl implements HomePageAdService {
	private final HomePageAdRepository repository;

	public HomePageAdServiceImpl(HomePageAdRepository repository) {
		this.repository = repository;
	}


	@Override
	public Advert insert(Advert advert) {
		var result = repository.save(advert);
		return result;
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Advert update(Advert advert) {
		var origin = findById(advert.getId());
		if(origin != null) {
			repository.save(advert);
		}
		return advert;
	}

	@Override
	public Advert findById(Integer id) {
		var result = repository.findById(id).orElse(null);
		return result;
	}

	@Override
	public Page<Advert> findAll(Pageable pageable) {
		var result = repository.findAllByOrderByCategoryAscPageAsc(pageable);
		return result;
	}
}
