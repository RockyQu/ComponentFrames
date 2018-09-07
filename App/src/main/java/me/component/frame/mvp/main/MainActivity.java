package me.component.frame.mvp.main;

import android.support.annotation.NonNull;
import android.os.Bundle;

import me.component.frame.R;
import me.component.frame.databinding.ActivityMainBinding;
import me.component.sdk.core.RouterHub;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IView;
import me.mvp.frame.frame.Message;
import me.mvp.frame.widget.Toaster;
import me.router.annotation.ComponentRouter;

@ComponentRouter(path = RouterHub.APP_MAINACTIVITY)
public class MainActivity extends BaseActivity<MainPresenter, ActivityMainBinding> implements IView {

    @Override
    public void create(Bundle savedInstanceState) {

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