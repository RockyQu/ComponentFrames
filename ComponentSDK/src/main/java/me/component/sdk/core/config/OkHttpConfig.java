package me.component.sdk.core.config;

import android.content.Context;

import me.mvp.frame.di.module.HttpModule;
import okhttp3.OkHttpClient;

/**
 * 扩展自定义配置 OkHttp 参数
 */
public class OkHttpConfig implements HttpModule.OkHttpConfiguration {

    @Override
    public void configOkHttp(Context context, OkHttpClient.Builder builder) {

    }
}