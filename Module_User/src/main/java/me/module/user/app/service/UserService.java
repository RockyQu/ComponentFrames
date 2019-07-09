package me.module.user.app.service;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.launcher.ARouter;

import me.component.sdk.core.RouterHub;
import me.component.sdk.entity.User;
import me.component.sdk.service.IUserService;
import me.component.sdk.utils.MainLooper;
import me.logg.Logg;
import me.mvp.frame.di.component.AppComponent;
import me.mvp.frame.utils.AppUtils;

/**
 * 根据业务的抽象接口，在相应的 Module 实现自己的业务逻辑
 */
@Route(path = RouterHub.User.Service.USER_SERVICE)
public class UserService implements IUserService {

    private AppComponent component;

    @Override
    public void init(Context context) {
        this.component = AppUtils.obtainAppComponentFromContext(context);
    }

    @Override
    public void transferUser(User user) {
        this.test(user);
    }

    /**
     * 弹出一个测试对话框
     *
     * @param user
     */
    private void test(final User user) {
        MainLooper.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                new AlertDialog.Builder(component.appManager().getCurrentActivity())
                        .setCancelable(false)
                        .setTitle("收到消息")
                        .setMessage(component.getGson().toJson(user))
                        .setNegativeButton("跳转到下一页", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 来自调用服务，接收到其他 Module 的传值，直接跳转到下个页面
                                ARouter.getInstance().build(RouterHub.User.USER_ACTIVITY)
                                        .withObject("user", user)
                                        .greenChannel()
                                        .navigation();
                            }
                        })
                        .setPositiveButton("取消", null)
                        .create()
                        .show();
            }
        });
    }
}