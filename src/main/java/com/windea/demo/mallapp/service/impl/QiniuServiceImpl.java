package com.windea.demo.mallapp.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.windea.demo.mallapp.service.QiniuService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("com.qiniu")
public class QiniuServiceImpl implements QiniuService {
	private static final Log logger = LogFactory.getLog(QiniuServiceImpl.class);

	private String accessKey;
	private String secretKey;
	private String bucket;


	/**
	 * 获取覆盖同名文件的上传凭证。
	 */
	@Override
	public String getToken(String key) {
		Auth auth = Auth.create(accessKey, secretKey);
		// 生成覆盖相同key文件的上传Token
		String upToken = auth.uploadToken(bucket, key, 3600, null, true);
		return upToken;
	}

	/**
	 * 删除七牛中指定key的文件。
	 */
	@Override
	public void deleteFile(String key) {
		// 构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		Auth auth = Auth.create(accessKey, secretKey);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		try {
			bucketManager.delete(bucket, key);
		} catch(QiniuException e) {
			// 如果遇到异常，说明删除失败
			logger.warn(e.code());
			logger.warn(e.response.toString());
		}
	}
}

