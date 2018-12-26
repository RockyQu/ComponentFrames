package me.component.sdk.utils;

import android.content.Context;

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
}