package me.component.sdk.core.config;

import android.content.Context;

import com.google.gson.GsonBuilder;

import me.mvp.frame.di.module.AppModule;

/**
 * 扩展自定义配置 Gson 参数
 */
public class GsonConfig implements AppModule.GsonConfiguration {

    @Override
    public void configGson(Context context, GsonBuilder builder) {
        builder
                .serializeNulls()// 支持序列化null的参数
        ;
    }
}