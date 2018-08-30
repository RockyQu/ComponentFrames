package me.module.user.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.squareup.leakcanary.RefWatcher;

import java.util.List;

import me.component.service.entity.User;
import me.mvp.frame.base.App;
import me.mvp.frame.base.delegate.ApplicationLifecycles;
import me.mvp.frame.di.module.AppConfigModule;
import me.mvp.frame.integration.ConfigModule;

/**
 * 全局配置信息在此配置，需要将此实现类声明到 AndroidManifest 中
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
        lifecycles.add(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
                ((RefWatcher) ((App) f.getActivity().getApplication()).getAppComponent().extras().get(RefWatcher.class.getName())).watch(this);
            }
        });
    }
}