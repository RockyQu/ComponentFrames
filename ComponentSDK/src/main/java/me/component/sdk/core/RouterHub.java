package me.component.sdk.core;

/**
 * {@link RouterHub} 用来定义全局路由地址, 方便统一查看和管理所有分组的路由地址
 */
public interface RouterHub {

    /**
     * 组件名
     */
    String APP = "/app";// APP
    String LOGIN = "/login";// 登录模块
    String USER = "/user";// 用户模块

    // 全局降级
    String DEGRADE_SERVICE = "/degrade/service";

    /**
     * App 分组
     */
    interface App {
        // 主页面
        String MAIN_ACTIVITY = APP + "/MainActivity";
        // 一个测试网页跳转的页面
        String WEB_ACTIVITY = APP + "/WebActivity";
    }

    /**
     * 登录分组
     */
    interface Login {
        // 用户登录页面
        String LOGIN_ACTIVITY = LOGIN + "/LoginActivity";
    }

    /**
     * 用户分组
     */
    interface User {
        // 用户信息页面
        String USER_ACTIVITY = USER + "/UserActivity";

        interface Fragment {
            String USER_FRAGMENT = USER + "/UserFragment";
        }

        interface Service {
            String USER_SERVICE = USER + "/UserService";
        }
    }
}