package me.router.api;

import android.app.Application;

/**
 *
 */
public class Router {

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


}