package me.module.user.user;

import android.os.Bundle;
import android.support.annotation.NonNull;

import me.module.user.R;
import me.module.user.databinding.ActivityUserBinding;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IView;
import me.mvp.frame.frame.Message;
import me.mvp.frame.widget.Toaster;

/**
 * 用户页面
 */
public class UserActivity extends BaseActivity<UserPresenter, ActivityUserBinding> implements IView {

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
    public UserPresenter obtainPresenter() {
        return new UserPresenter(component);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_user;
    }
}