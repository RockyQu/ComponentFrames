package me.module.login.app;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.RefWatcher;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import me.component.sdk.entity.User;
import me.module.login.login.LoginActivity;
import me.mvp.frame.base.App;
import me.mvp.frame.base.delegate.ApplicationLifecycles;
import me.mvp.frame.di.module.AppConfigModule;
import me.mvp.frame.integration.ConfigModule;
import me.mvp.frame.utils.GsonUtils;
import me.mvp.frame.utils.PreferencesUtils;

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
                // 读取当前登录用户信息
                String value = PreferencesUtils.getString(application, LoginActivity.class.getName(), null);
                if (value != null) {
                    User user = GsonUtils.getEntity(value, User.class);
                    ((App) application).getAppComponent().extras().put(LoginActivity.class.getName(), user);
                }
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
        lifecycles.add(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
                ((RefWatcher) ((App) f.getActivity().getApplication()).getAppComponent().extras().get(RefWatcher.class.getName())).watch(this);
            }
        });
    }
}