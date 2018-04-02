package com.tonkor;

import cn.jlook.api.service.ApiLogic;
import cn.jlook.api.service.impl.BaseApiLogicV2;

@ApiLogic(version = "1.0.1")
public class Api {
	@ApiLogic(value = "/", target = BaseApiLogicV2.class)
	public int basic;
}
