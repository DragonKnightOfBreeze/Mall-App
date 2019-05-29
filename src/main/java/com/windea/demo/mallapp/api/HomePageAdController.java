package com.windea.demo.mallapp.api;

import com.windea.demo.mallapp.domain.Advert;
import com.windea.demo.mallapp.service.HomePageAdService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Advert insert(@RequestBody Advert advert) {
		var result = service.insert(advert);
		return result;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@PutMapping("/update")
	public Advert update(@RequestBody Advert advert) {
		var result = service.update(advert);
		return result;
	}

	@GetMapping("/{id}")
	public Advert get(@PathVariable Integer id) {
		var result = service.findById(id);
		return result;
	}

	@GetMapping("/list")
	public Page<Advert> list(@RequestParam Integer page, @RequestParam Integer size) {
		var pageable = PageRequest.of(page, size);
		var result = service.findAll(pageable);
		return result;
	}
}
