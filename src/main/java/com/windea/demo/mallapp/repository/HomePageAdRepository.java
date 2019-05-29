package com.windea.demo.mallapp.repository;

import com.windea.demo.mallapp.domain.Advert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomePageAdRepository extends JpaRepository<Advert, Integer> {
	Page<Advert> findAllByOrderByCategoryAscPageAsc(Pageable pageable);
}
