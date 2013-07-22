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
     * put key-value to context
     * 
     * @param key
     * @param value
     * @param scope
     */
    public static void put(String key, Object value, ContextScope scope) {
        switch (scope) {
            case GLOBAL_SESSION:
                requestThread.get().getServletContext().setAttribute(key, value);
            case SESSION:
                requestThread.get().getSession().setAttribute(key, value);
            case REQUEST:
                requestThread.get().setAttribute(key, value);
                break;
        }
    }

    /**
     * get value by key from context.
     * 
     * @param key
     * @param classOfT
     * @return
     */
    public static <T> T get(String key, Class<T> classOfT) {
        T t = classOfT.cast(requestThread.get().getAttribute(key));
        if (t == null) {
            t = classOfT.cast(requestThread.get().getSession().getAttribute(key));
            if (t == null) {
                t = classOfT.cast(requestThread.get().getServletContext().getAttribute(key));
            }
        }
        return t;
    }

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
