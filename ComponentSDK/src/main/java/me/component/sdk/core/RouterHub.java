package me.component.sdk.core;

/**
 * {@link RouterHub} 用来定义全局路由地址, 方便统一查看和管理所有分组的路由地址
 */
public interface RouterHub {

    /**
     * 组件名
     */
    String APP = "/app";// APP
    String LOGIN = "/login";// 登录
    String USER = "/user";// 用户

    /**
     * App 分组
     */
    String APP_MAINACTIVITY = APP + "/MainActivity";

    /**
     * 登录分组
     */
    String LOGIN_LOGINACTIVITY = LOGIN + "/LoginActivity";

    /**
     * 用户分组
     */
    String USER_USERACTIVITY = USER + "/UserActivity";
}
