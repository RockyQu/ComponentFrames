package me.router.annotation.entity;

/**
 *
 */
public class RouterMeta {

    /**
     *
     */
    private String path;

    /**
     *
     */
    private Class<?> destination;

    public RouterMeta(String path, Class<?> destination) {
        this.path = path;
        this.destination = destination;
    }

    public static RouterMeta build(String path, Class<?> destination) {
        return new RouterMeta(path, destination);
    }

}