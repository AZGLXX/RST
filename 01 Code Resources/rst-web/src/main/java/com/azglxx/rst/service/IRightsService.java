package com.azglxx.rst.service;

import com.azglxx.common.context.UserInfo;

public interface IRightsService extends IService {
	
	void validateUser(UserInfo userInfo);
}
