package me.component.frame.mvp.scheme;

import android.net.Uri;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import me.component.frame.R;
import me.component.sdk.core.RouterHub;
import me.logg.Logg;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IPresenter;

/**
 * 通过注册一个没有 UI 的页面来作为跳板来统一处理，然后再进行分发跳转
 *
 * 特点：
 * 1.增强页面跳转的灵活性，比如和 H5 进行通信，H5 需要跳转到 App 本地的页面，Native 和 H5 只需要统路径 Url 即可，
 * H5 可以构造一个 Url 就可以实现跳转到对应页面的功能
 * 2.更加的安全，相比隐式 Intent，每一个从外面跳转进来的页面都需要注册上 intent-filter，每个页面都需要设置 exported = true，
 * 也就是每个页面在外部都可以访问到，这样做会带来非常严重的安全风险。而使用的这种场景只需要对外暴露出一个 Activity，
 * 然后在这个 Activity中注册一个 intent-filter，这样之后所有的外部路由请求都会经过这唯一的门，然后在这个 Activity 中
 * 获取到 URL 并将其交给 ARouter 再进行分发跳转
 * 3.携带参数注入，隐式 Intent 跳转无法将参数自动注入，ARouter 可以在 Url 中携带参数后完成自动注入
 */
public class SchemeActivity extends BaseActivity {

    @Override
    public void create(Bundle savedInstanceState) {
        Uri uri = getIntent().getData();
        ARouter.getInstance().build(uri).navigation(this, new NavCallback() {

            @Override
            public void onArrival(Postcard postcard) {
                finish();
            }
        });
    }

    @Override
    public IPresenter obtainPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }
}
