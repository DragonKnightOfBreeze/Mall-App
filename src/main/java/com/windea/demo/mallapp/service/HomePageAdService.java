package com.windea.demo.mallapp.service;

import com.windea.demo.mallapp.domain.HomePageAd;

public interface HomePageAdService {
	HomePageAd insert(HomePageAd homePageAd);

	void deleteById(Integer id);

	HomePageAd update(HomePageAd homePageAd);

	HomePageAd findById(Integer id);
}
