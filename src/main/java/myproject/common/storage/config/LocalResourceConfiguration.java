package myproject.common.storage.config;


import myproject.common.storage.enums.StorageTypeEnum;
import myproject.common.storage.properties.LocalStorageProperties;
import myproject.common.storage.properties.StorageProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 本地资源映射配置
 */
@Configuration
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class LocalResourceConfiguration implements WebMvcConfigurer {
	@Resource
	private StorageProperties properties;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 如果不是本地存储，则返回
		if (properties.getConfig().getType() != StorageTypeEnum.LOCAL) {
			return;
		}

		LocalStorageProperties local = properties.getLocal();
		registry.addResourceHandler("/" + local.getUrl() + "/**")
				.addResourceLocations("file:" + local.getPath() + "/");
	}
}