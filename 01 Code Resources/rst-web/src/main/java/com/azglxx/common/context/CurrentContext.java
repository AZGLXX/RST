/**
 * 
 */
package com.azglxx.common.context;

import javax.servlet.http.HttpServletRequest;

import com.azglxx.common.constants.SessionKey;

/**
 * request current context
 * 
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 * @date 2013-7-20
 * @version 1.0
 */
public class CurrentContext {

    private static ThreadLocal<HttpServletRequest> requestThread = new ThreadLocal<HttpServletRequest>();

    /**
     * Get current user
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
     * Set current user
     * 
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

    public static void invalidSession() {
        requestThread.get().getSession().invalidate();
    }

    public static HttpServletRequest getHttpServletRequest() {
        return requestThread.get();
    }
}
