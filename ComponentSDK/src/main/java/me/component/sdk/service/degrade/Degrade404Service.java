package me.component.sdk.service.degrade;

import android.app.AlertDialog;
import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

import me.component.sdk.core.RouterHub;
import me.component.sdk.utils.MainLooper;
import me.mvp.frame.di.component.AppComponent;
import me.mvp.frame.utils.AppUtils;

/**
 * 全局降级
 */
@Route(path = RouterHub.DEGRADE_SERVICE)
public class Degrade404Service implements DegradeService {

    private AppComponent component;

    @Override
    public void init(Context context) {
        this.component = AppUtils.obtainAppComponentFromContext(context);
    }

    @Override
    public void onLost(Context context, Postcard postcard) {
        this.test();
    }

    /**
     * 弹出一个测试对话框
     */
    private void test() {
        MainLooper.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                new AlertDialog.Builder(component.appManager().getCurrentActivity())
                        .setCancelable(false)
                        .setTitle("全局降级")
                        .setMessage("没有找到目标页面，你可以定义自己的逻辑，比如显示一个错误页面")
                        .setNegativeButton("确定", null)
                        .setPositiveButton("取消", null)
                        .create()
                        .show();
            }
        });
    }
}