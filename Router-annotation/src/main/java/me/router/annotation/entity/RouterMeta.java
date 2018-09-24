package me.router.annotation.entity;

import me.router.annotation.enums.RouterType;

/**
 *
 */
public class RouterMeta {

    /**
     *
     */
    private RouterType type;

    /**
     *
     */
    private String path;

    /**
     *
     */
    private Class<?> destination;

    public RouterMeta() {

    }

    public RouterMeta(String path, Class<?> destination) {
        this.path = path;
        this.destination = destination;
    }

    public static RouterMeta build(String path, Class<?> destination) {
        return new RouterMeta(path, destination);
    }

}