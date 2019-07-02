package me.module.login.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jakewharton.rxbinding3.view.RxView;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;
import me.component.sdk.core.RouterHub;
import me.component.sdk.entity.User;
import me.logg.Logg;
import me.module.login.R;
import me.module.login.R2;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IView;
import me.mvp.frame.frame.Message;
import me.mvp.frame.utils.StringUtils;
import me.mvp.frame.widget.Toaster;

/**
 * 登录页面
 */
@Route(path = RouterHub.Login.LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity<LoginPresenter> implements IView {

    @BindView(R2.id.title)
    AppCompatTextView title;
    @BindView(R2.id.message)
    AppCompatTextView message;

    @Autowired
    User user;

    @Override
    public void create(Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);

        String params = String.format(
                "user = %s",
                component.getGson().toJson(user)
        );

        message.setText(params);
    }

    @OnClick({R2.id.message})
    public void onClick(View v) {
        finish();
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
    public LoginPresenter obtainPresenter() {
        return new LoginPresenter(component);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }
}