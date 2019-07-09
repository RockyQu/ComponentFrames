package me.component.sdk.utils;

import android.app.Activity;
import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.launcher.ARouter;

public class RouterUtils {

    /**
     * 页面跳转
     *
     * @param context
     * @param path
     */
    public static void navigation(Context context, String path) {
        ARouter.getInstance().build(path).navigation(context);
    }

    /**
     * 页面跳转
     *
     * @param context
     * @param path
     * @param requestCode
     */
    public static void navigation(Activity context, String path, int requestCode) {
        ARouter.getInstance().build(path).navigation(context, requestCode);
    }

    /**
     * 获取服务
     *
     * @param path
     * @param <T>
     * @return
     */
    public static <T extends IProvider> T provider(String path) {
        IProvider provider = null;
        try {
            provider = (IProvider) ARouter.getInstance().build(path).navigation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) provider;
    }

    /**
     * 获取服务
     *
     * @param clz
     * @param <T>
     * @return
     */
    public static <T extends IProvider> T provider(Class<T> clz) {
        IProvider provider = null;
        try {
            provider = ARouter.getInstance().navigation(clz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) provider;
    }
}