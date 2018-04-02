package com.tonkor;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.FakeStaticHandler;

import cn.jlook.CMSConfig;
import cn.jlook.api.util.ApiUtils;
import cn.jlook.jfinal.ext3.plugin.qiniu.QiniuKit;
import httl.web.jfinal.HttlRenderFactory;

public class ServerConfig extends CMSConfig {

	@Override
	public void configMoreConstants(Constants me) {
		me.setMainRenderFactory(new HttlRenderFactory());
	}

	@Override
	public void configMoreRoutes(Routes me) {

	}

	@Override
	public void configMorePlugins(Plugins me) {
		// 七牛
		String uploadType = getProperty("cms.upload.type");
		final String ak = "cms.upload.%s.ak", sk = "cms.upload.%s.sk", bucket = "cms.upload.%s.bucket",
				domain = "cms.upload.%s.url";
		QiniuKit.init(getProperty(String.format(ak, uploadType)), getProperty(String.format(sk, uploadType)),
				getProperty(String.format(bucket, uploadType)), getProperty(String.format(domain, uploadType)));
	}

	@Override
	public void configMoreInterceptors(Interceptors me) {

	}

	@Override
	public void configMoreHandlers(Handlers me) {
		// 伪静态
		me.add(new FakeStaticHandler(".html"));
	}

	@Override
	public void afterJFinalStarted() {
		ApiUtils.init(Api.class);
	}

}
