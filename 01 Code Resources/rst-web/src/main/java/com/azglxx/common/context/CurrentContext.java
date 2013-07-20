/**
 * 
 */
package com.azglxx.common.context;

import javax.servlet.http.HttpServletRequest;

import com.azglxx.common.constants.SessionKey;

/**
 * request请求的当前上下文。
 * 
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 * @date 2013-7-20
 * @version 1.0
 */
public class CurrentContext {

	private static ThreadLocal<HttpServletRequest> requestThread = new ThreadLocal<HttpServletRequest>();

	/**
	 * 获取当前用户
	 * 
	 * @date 2013-7-20
	 * @return
	 */
	public static UserInfo getCurrentUser() {
		UserInfo user = (UserInfo) requestThread.get().getAttribute(SessionKey.CURRENT_USER_KEY);
		if (user == null) {
			user = (UserInfo) requestThread.get().getSession().getAttribute(SessionKey.CURRENT_USER_KEY);
		}
		return user;
	}

	/**
	 * 设置当前用户
	 * @date 2013-7-20
	 * @param user
	 */
	public static void setCurrentUser(UserInfo user) {
		requestThread.get().setAttribute(SessionKey.CURRENT_USER_KEY, user);
		requestThread.get().getSession().setAttribute(SessionKey.CURRENT_USER_KEY, user);
	}

	public static void initialize(HttpServletRequest request) {
		requestThread.set(request);
	}

	public static void release() {
		requestThread.set(null);
	}
}
