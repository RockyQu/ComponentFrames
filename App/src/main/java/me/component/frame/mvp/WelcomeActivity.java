package me.component.frame.mvp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import me.component.frame.R;
import me.component.frame.mvp.main.MainActivity;
import me.component.sdk.core.AppConfiguration;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IPresenter;
import me.mvp.frame.utils.AppUtils;
import me.mvp.frame.utils.PermissionUtils;
import me.mvp.frame.utils.ProjectUtils;

/**
 * 欢迎页面
 */
public class WelcomeActivity extends BaseActivity {

    @Override
    public void create(Bundle savedInstanceState) {
        startNextActivity();
    }

    /**
     * 跳转下一页面
     */
    @SuppressLint("CheckResult")
    private void startNextActivity() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                        WelcomeActivity.this.finish();
                    }
                });
    }

    @Override
    public IPresenter obtainPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }
}