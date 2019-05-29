package com.windea.demo.mallapp.api;

import com.windea.demo.mallapp.domain.GuidePage;
import com.windea.demo.mallapp.domain.GuidePageSearchVo;
import com.windea.demo.mallapp.service.GuidePageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/guide-page")
public class GuidePageController {
	private final GuidePageService service;

	public GuidePageController(GuidePageService service) {
		this.service = service;
	}

	@PostMapping("/insert")
	public GuidePage insert(@RequestBody GuidePage guidePage) {
		var result = service.insert(guidePage);
		return result;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@PutMapping("/update")
	public GuidePage update(@RequestBody GuidePage guidePage) {
		var result = service.update(guidePage);
		return result;
	}

	@GetMapping("/{id}")
	public GuidePage get(@PathVariable Integer id) {
		var result = service.findById(id);
		return result;
	}

	@GetMapping("/list")
	public Page<GuidePage> list(
		@RequestParam Integer page, @RequestParam Integer size
	) {
		var pageable = PageRequest.of(page, size);
		var result = service.findAll(pageable);
		return result;
	}

	@PostMapping("/search")
	public Page<GuidePage> search(
		@RequestParam Integer page, @RequestParam Integer size,
		@RequestBody GuidePageSearchVo searchVo
	) {
		var pageable = PageRequest.of(page, size);
		var result = service
			.findAllByConditions(searchVo.getAdTitle(), searchVo.getAdLeft(), searchVo.getAdRight(), pageable);
		return result;
	}
}
