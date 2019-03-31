package me.component.frame.app;

import android.app.Application;
import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
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
        lifecycleManager.add(new ApplicationLifecycles() {

            @Override
            public void attachBaseContext(@NonNull Context base) {

            }

            @Override
            public void onCreate(@NonNull Application application) {

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