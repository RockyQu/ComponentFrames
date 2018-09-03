package me.component.frame.app;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import java.util.List;

import me.mvp.frame.base.delegate.ApplicationLifecycles;
import me.mvp.frame.di.module.AppConfigModule;
import me.mvp.frame.integration.ConfigModule;

/**
 * 全局配置信息在此配置，需要将此实现类声明到 AndroidManifest 中
 * 部分公用配置信息在 ComponentSDK 中已经配置 {@link me.component.sdk.core.AppConfiguration}
 * 组件 Module {@link AppConfiguration} 里用来配置一些组件自身私有的配置信息
 */
public class AppConfiguration implements ConfigModule {

    @Override
    public void applyOptions(final Context context, AppConfigModule.Builder builder) {

    }

    @Override
    public void injectApplicationLifecycle(Context context, List<ApplicationLifecycles> lifecycleManager) {

    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {

    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {

    }
}