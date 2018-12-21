package me.router.annotation.entity;

import javax.lang.model.element.Element;

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
    private Element element;

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

    public RouterMeta(RouterType type, Element element, String path, Class<?> destination) {
        this.type = type;
        this.element = element;
        this.path = path;
        this.destination = destination;
    }


    /**
     * 路由表初始化调用此方法
     *
     * @param type
     * @param path
     * @param destination
     * @return
     */
    public static RouterMeta build(RouterType type, String path, Class<?> destination) {
        return new RouterMeta(type, null, path, destination);
    }

    public static RouterMeta build(RouterType type, String path) {
        return new RouterMeta(type, null, path, null);
    }

    /**
     * @param type
     * @param element
     * @param path
     * @return
     */
    public static RouterMeta build(RouterType type, Element element, String path) {
        return new RouterMeta(type, element, path, null);
    }

    public RouterType getType() {
        return type;
    }

    public void setType(RouterType type) {
        this.type = type;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Class<?> getDestination() {
        return destination;
    }

    public void setDestination(Class<?> destination) {
        this.destination = destination;
    }
}