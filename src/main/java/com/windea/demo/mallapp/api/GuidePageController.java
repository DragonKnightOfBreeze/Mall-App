package com.windea.demo.mallapp.api;

import com.windea.demo.mallapp.domain.GuidePage;
import com.windea.demo.mallapp.domain.GuidePageSearchVo;
import com.windea.demo.mallapp.service.GuidePageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@PostMapping("/search")
	public List<GuidePage> search(@RequestBody GuidePageSearchVo searchVo) {
		var result = service.findByConditions(searchVo.getAdTitle(), searchVo.getAdLeft(), searchVo.getAdRight());
		return result;
	}
}
