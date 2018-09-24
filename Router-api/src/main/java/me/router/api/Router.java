package me.router.api;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

import me.router.annotation.entity.RouterMeta;

/**
 *
 */
public class Router {

    /**
     *
     */
    private Map<String, RouterMeta> routerMetaMap = new HashMap<>();

    private Router() {

    }

    /**
     * @param application
     */
    public static synchronized boolean init(Application application) {

        return true;
    }

    private static class SingletonHolder {
        private static Router INSTANCE = new Router();
    }

    public static final Router getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 路由注册
     */
    public void register(String key, RouterMeta routerMeta) {
        routerMetaMap.put(key, routerMeta);
    }
}