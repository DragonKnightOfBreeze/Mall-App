package com.windea.demo.mallapp.api;

import com.windea.demo.mallapp.domain.HomePageAd;
import com.windea.demo.mallapp.service.HomePageAdService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/home-page-ad")
public class HomePageAdController {
	private final HomePageAdService service;

	public HomePageAdController(HomePageAdService service) {
		this.service = service;
	}

	@PostMapping("/insert")
	public HomePageAd insert(@RequestBody HomePageAd homePageAd) {
		var result = service.insert(homePageAd);
		return result;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@PutMapping("/update")
	public HomePageAd update(@RequestBody HomePageAd homePageAd) {
		var result = service.update(homePageAd);
		return result;
	}

	@GetMapping("/{id}")
	public HomePageAd get(@PathVariable Integer id) {
		var result = service.findById(id);
		return result;
	}
}
