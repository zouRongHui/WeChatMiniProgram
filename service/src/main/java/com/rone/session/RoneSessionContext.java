package com.rone.session;

import com.rone.exception.SessionDueException;
import com.rone.exception.RoneException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义的HttpSession维护类，用于解决微信小程序和h5页面请求时无法设置同一个sessionId的问题
 *
 * @author rone
 */
public class RoneSessionContext {

    /**
     * session的有效期，单位秒。由于现在session是自己写的方法去实现的，所以需要自己去手动增加时长
     */
    public static final Integer SESSION_TIME_OUT = 30 * 60;
    /**
     * 单例实体
     */
    private static RoneSessionContext roneSessionContext;
    /**
     * session维护Map
     */
    private final Map<String, HttpSession> map;

    private RoneSessionContext() {
        map = new HashMap();
    }

    public static RoneSessionContext getInstance() {
        if (roneSessionContext == null) {
            roneSessionContext = new RoneSessionContext();
        }
        return roneSessionContext;
    }

    public synchronized void addSession(HttpSession session) {
        if (session != null) {
            map.put(session.getId(), session);
        }
    }

    public synchronized void delSession(HttpSession session) {
        if (session != null) {
            map.remove(session.getId());
        }
    }

    public synchronized HttpSession getSession(String sessionId) throws RoneException {
        if (StringUtils.isEmpty(sessionId)) {
            throw new RoneException("请求失败，无登陆凭证");
        }
        HttpSession session = map.get(sessionId.trim());
        if (session == null) {
            throw new SessionDueException("请求失败，登陆凭证过期");
        }
        session.setMaxInactiveInterval(SESSION_TIME_OUT);
        return session;
    }
}
