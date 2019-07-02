package me.module.user.user.interceptor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import me.component.sdk.entity.User;
import me.component.sdk.utils.Conts;
import me.component.sdk.utils.MainLooper;
import me.mvp.frame.utils.AppUtils;

/**
 * 在需要用户登录的页面，添加拦截器，在跳转前统一判断是否登录的一些逻辑
 */
@Interceptor(priority = 1, name = "LoginInterceptor")
public class LoginInterceptor implements IInterceptor {

    private Context context;

    @Override
    public void init(Context context) {
        this.context = context;
    }

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getExtra() == Conts.LOGIN_NEEDED) {
            boolean isLogin = AppUtils.obtainAppComponentFromContext(context).extras().get(Conts.KEY_IS_LOGIN) != null;
            if (isLogin) {// 已经登录，继续执行
                callback.onContinue(postcard);
            } else {// 没有登录
                this.test(postcard, callback);
            }
        } else {// 无需登录，继续执行
            callback.onContinue(postcard);
        }
    }

    /**
     * 弹出一个测试对话框
     *
     * @param postcard
     * @param callback
     */
    private void test(final Postcard postcard, final InterceptorCallback callback) {
        MainLooper.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Context currentContext = AppUtils.obtainAppComponentFromContext(context).appManager().getCurrentActivity();
                new AlertDialog.Builder(currentContext)
                        .setCancelable(false)
                        .setTitle("登录被拦截了")
                        .setMessage(postcard.toString())
                        .setNegativeButton("继续", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 在拦截器中添加附加参数
                                User user = new User("20190628", "小王");
                                postcard.withObject("user", user);
                                // 继续执行
                                callback.onContinue(postcard);
                            }
                        })
                        .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                callback.onInterrupt(null);
                            }
                        })
                        .create()
                        .show();
            }
        });
    }
}