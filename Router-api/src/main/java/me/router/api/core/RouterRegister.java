package me.router.api.core;

import java.util.Map;

/**
 * 路由表注册
 */
public interface RouterRegister {

    /**
     * @param routerMetaMap
     */
    void register(Map<String, RouterMeta> routerMetaMap);
}