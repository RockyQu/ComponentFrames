package me.router.annotation.enums;

/**
 *
 */
public enum RouterType {

    ACTIVITY(0, "android.app.Activity"),
    UNKNOWN(-1, "Unknown route type");

    int id;
    String className;

    public int getId() {
        return id;
    }

    public RouterType setId(int id) {
        this.id = id;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public RouterType setClassName(String className) {
        this.className = className;
        return this;
    }

    RouterType(int id, String className) {
        this.id = id;
        this.className = className;
    }

    public static RouterType parse(String name) {
        for (RouterType routerType : RouterType.values()) {
            if (routerType.getClassName().equals(name)) {
                return routerType;
            }
        }

        return UNKNOWN;
    }
}
