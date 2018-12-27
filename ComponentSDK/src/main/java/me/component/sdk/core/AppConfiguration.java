package me.component.sdk.core;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

import me.component.sdk.BuildConfig;
import me.component.sdk.core.config.DBConfig;
import me.component.sdk.core.config.GlobalErrorConfig;
import me.component.sdk.core.config.GsonConfig;
import me.component.sdk.core.config.OkHttpConfig;
import me.component.sdk.core.config.RetrofitConfig;
import me.component.sdk.core.config.RxCacheConfig;
import me.component.sdk.http.Api;
import me.mvp.frame.base.delegate.ApplicationLifecycles;
import me.mvp.frame.di.module.AppConfigModule;
import me.mvp.frame.http.interceptor.NetworkInterceptor;
import me.mvp.frame.integration.ConfigModule;

/**
 * ComponentSDK 的 {@link AppConfiguration} 含有有每个组件的公用配置信息，每个组件的 AndroidManifest
 * 必须声明此 ConfigModule，其配置才可以生效
 */
public class AppConfiguration implements ConfigModule {

    // 渠道名称，必须与 Mainfests 渠道配置 name 相同
    public static final String CHANNEL = "Channel";

    @Override
    public void applyOptions(final Context context, AppConfigModule.Builder builder) {
        if (BuildConfig.DEBUG_FLAG) { // 只在 Debug 时打印日志
            builder.httpLogLevel(NetworkInterceptor.Level.ALL);
        } else {
            builder.httpLogLevel(NetworkInterceptor.Level.NONE);
        }

        builder
                .httpUrl(Api.APP_DOMAIN)
                .dbConfiguration(new DBConfig())
                .retrofitConfiguration(new RetrofitConfig())
                .okHttpConfiguration(new OkHttpConfig())
                .globalErrorHandler(new GlobalErrorConfig())
                .rxCacheConfiguration(new RxCacheConfig())
                .gsonConfiguration(new GsonConfig())
        ;
    }

    @Override
    public void injectApplicationLifecycle(Context context, List<ApplicationLifecycles> lifecycleManager) {
        lifecycleManager.add(new ApplicationLifecycles() {

            @Override
            public void attachBaseContext(@NonNull Context base) {

            }

            @Override
            public void onCreate(@NonNull Application application) {
                if (BuildConfig.DEBUG_FLAG) {
                    ARouter.openLog();
                    ARouter.openDebug();
                }
                ARouter.init(application);
            }

            @Override
            public void onTerminate(@NonNull Application application) {

            }
        });
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {

    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {

    }
}