package me.router.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记目标类的路由信息
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface ComponentRouter {

    /**
     * 路由唯一路径
     */
    String path();
}