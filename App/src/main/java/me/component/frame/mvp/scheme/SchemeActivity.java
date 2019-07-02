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
 * 外部跳转中转页面
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
        return R.layout.activity_scheme;
    }
}
