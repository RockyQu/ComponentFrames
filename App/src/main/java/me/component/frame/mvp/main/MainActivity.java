package me.component.frame.mvp.main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;

import me.component.frame.R;
import me.component.sdk.core.RouterHub;
import me.component.sdk.entity.User;
import me.logg.Logg;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IView;
import me.mvp.frame.frame.Message;
import me.mvp.frame.widget.Toaster;

@Route(path = RouterHub.App.MAIN_ACTIVITY)
public class MainActivity extends BaseActivity<MainPresenter> implements IView, View.OnClickListener {

    @Override
    public void create(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigation:// 应用内跳转
                ARouter.getInstance().build(RouterHub.Login.LOGIN_ACTIVITY).navigation();
                break;
            case R.id.navigationWithParams:// 传值并依赖注入
                User user = new User("20190627", "老王");
                ARouter.getInstance().build(RouterHub.Login.LOGIN_ACTIVITY)
                        .withString("userId", user.getUserId())
                        .withString("name", user.getName())
                        .withParcelable("user", user)
                        .navigation();
                break;
            case R.id.navigationWithAnim:// 转场动画
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(v, v.getWidth() / 2, v.getHeight() / 2, 0, 0);
                ARouter.getInstance()
                        .build(RouterHub.Login.LOGIN_ACTIVITY)
                        .withOptionsCompat(compat)
                        .navigation();
                break;
            case R.id.navigationWithWeb:// URL 跳转
                ARouter.getInstance().build(RouterHub.App.WEB_ACTIVITY).navigation();
                break;
            case R.id.loginInterceptor:// 登录拦截
                ARouter.getInstance().build(RouterHub.User.USER_ACTIVITY).navigation(this, new NavCallback() {

                    @Override
                    public void onArrival(Postcard postcard) {
                        Logg.e("onArrival");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Logg.e("onInterrupt");
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:

                break;
            default:
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(int type, @NonNull String message) {
        Toaster.with(this).setMessage(message).show();
    }

    @Override
    public void handleMessage(@NonNull Message message) {

    }

    @Override
    public MainPresenter obtainPresenter() {
        return new MainPresenter(component);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}