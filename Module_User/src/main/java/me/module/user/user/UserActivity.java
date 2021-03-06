package me.module.user.user;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import butterknife.OnClick;
import me.component.sdk.core.RouterHub;
import me.component.sdk.entity.User;
import me.component.sdk.utils.Conts;
import me.module.user.R;
import me.module.user.R2;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IView;
import me.mvp.frame.frame.Message;
import me.mvp.frame.widget.Toaster;

/**
 * 用户页面
 */
@Route(path = RouterHub.User.USER_ACTIVITY, extras = Conts.LOGIN_NEEDED)
public class UserActivity extends BaseActivity<UserPresenter> implements IView {

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

    @OnClick({R2.id.title})
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
    public UserPresenter obtainPresenter() {
        return new UserPresenter(component);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_user;
    }
}