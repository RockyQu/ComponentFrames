package me.router.annotation.entity;

import javax.lang.model.element.Element;

import me.router.annotation.enums.RouterType;

/**
 * 路由的基本信息
 */
public class RouterMeta {

    private int id;

    private RouterType type;
    private Element element;

    /**
     * 路由唯一路径，命名规则建议 /app/MainActivity 便于理解
     */
    private String path;

    /**
     * 路由目标
     */
    private Class<?> destination;

    public RouterMeta() {

    }

    public RouterMeta(int id, RouterType type, Element element, String path, Class<?> destination) {
        this.id = id;
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
    public static RouterMeta build(int id, RouterType type, String path, Class<?> destination) {
        return new RouterMeta(id, type, null, path, destination);
    }

    public static RouterMeta build(RouterType type, Element element, String path) {
        return new RouterMeta(path.hashCode(), type, element, path, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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