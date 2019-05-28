package com.windea.demo.mallapp.service.impl;

import com.windea.demo.mallapp.domain.GuidePage;
import com.windea.demo.mallapp.repository.GuidePageRepository;
import com.windea.demo.mallapp.service.GuidePageService;
import com.windea.demo.mallapp.service.QiniuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuidePageServiceImpl implements GuidePageService {
	private final GuidePageRepository repository;
	private final QiniuService qiniuUtils;

	public GuidePageServiceImpl(GuidePageRepository repository, QiniuService qiniuUtils) {
		this.repository = repository;
		this.qiniuUtils = qiniuUtils;
	}


	@Override
	public GuidePage insert(GuidePage guidePage) {
		var result = repository.save(guidePage);
		return result;
	}

	@Override
	public void deleteById(Integer id) {
		var origin = findById(id);
		repository.deleteById(id);
		//删除对应的文件
		var key = origin.getImgUrl().split("/")[origin.getImgUrl().split("/").length - 1];
		qiniuUtils.deleteFile(key);
	}

	@Override
	public GuidePage update(GuidePage guidePage) {
		var origin = findById(guidePage.getId());
		if(origin != null) {
			repository.save(guidePage);
		}
		return guidePage;
	}

	@Override
	public GuidePage findById(Integer id) {
		var result = repository.findById(id).orElse(null);
		return result;
	}

	@Override
	public List<GuidePage> findByConditions(String adTitle, String adLeft, String adRight) {
		var resultList = repository.findAllByAdTitleLikeOrAdLeftLikeOrAdRightLike(adTitle, adLeft, adRight);
		return resultList;
	}
}
