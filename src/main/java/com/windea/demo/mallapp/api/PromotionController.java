package com.windea.demo.mallapp.api;

import com.windea.demo.mallapp.domain.Promotion;
import com.windea.demo.mallapp.service.PromotionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/promotion")
public class PromotionController {
	private final PromotionService service;

	public PromotionController(PromotionService service) {
		this.service = service;
	}

	@PostMapping("/insert")
	public Promotion insert(@RequestBody Promotion promotion) {
		var result = service.insert(promotion);
		return result;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@PutMapping("/update")
	public Promotion update(@RequestBody Promotion promotion) {
		var result = service.update(promotion);
		return result;
	}

	@GetMapping("/{id}")
	public Promotion get(@PathVariable Integer id) {
		var result = service.findById(id);
		return result;
	}
}
