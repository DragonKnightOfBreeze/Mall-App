package com.windea.demo.mallapp.service;

public interface QiniuService {
	String getToken(String key);

	void deleteFile(String key);
}
