package me.component.frame.mvp.scheme;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import me.component.frame.R;
import me.component.sdk.core.RouterHub;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IPresenter;

/**
 * 外部跳转测试页面
 */
@Route(path = RouterHub.App.SCHEME_ACTIVITY)
public class SchemeActivity extends BaseActivity {



    @Override
    public void create(Bundle savedInstanceState) {

    }

    @Override
    public IPresenter obtainPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_scheme;
    }
}
