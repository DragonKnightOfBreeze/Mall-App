package com.windea.demo.mallapp.service;

import com.windea.demo.mallapp.domain.Advert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HomePageAdService {
	Advert insert(Advert advert);

	void deleteById(Integer id);

	Advert update(Advert advert);

	Advert findById(Integer id);

	Page<Advert> findAll(Pageable pageable);
}
