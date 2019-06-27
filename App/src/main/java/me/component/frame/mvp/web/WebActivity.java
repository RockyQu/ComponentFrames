package me.component.frame.mvp.web;

import android.os.Bundle;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import me.component.frame.R;
import me.component.sdk.core.RouterHub;
import me.mvp.frame.base.BaseActivity;
import me.mvp.frame.frame.IPresenter;

/**
 * WebView 页面
 */
@Route(path = RouterHub.App.WEB_ACTIVITY)
public class WebActivity extends BaseActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    public void create(Bundle savedInstanceState) {
        webView.loadUrl("file:///android_asset/schame-test.html");
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