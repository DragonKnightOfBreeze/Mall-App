package com.windea.demo.mallapp.service.impl;

import com.windea.demo.mallapp.domain.HomePageAd;
import com.windea.demo.mallapp.repository.HomePageAdRepository;
import com.windea.demo.mallapp.service.HomePageAdService;
import org.springframework.stereotype.Service;

@Service
public class HomePageAdServiceImpl implements HomePageAdService {
	private final HomePageAdRepository repository;

	public HomePageAdServiceImpl(HomePageAdRepository repository) {
		this.repository = repository;
	}


	@Override
	public HomePageAd insert(HomePageAd homePageAd) {
		var result = repository.save(homePageAd);
		return result;
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public HomePageAd update(HomePageAd homePageAd) {
		var origin = findById(homePageAd.getId());
		if(origin != null) {
			repository.save(homePageAd);
		}
		return homePageAd;
	}

	@Override
	public HomePageAd findById(Integer id) {
		var result = repository.findById(id).orElse(null);
		return result;
	}
}
