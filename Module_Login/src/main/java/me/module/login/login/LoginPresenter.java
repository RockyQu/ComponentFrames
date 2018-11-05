package me.module.login.login;

import me.component.sdk.entity.User;
import me.component.sdk.entity.base.ResponseEntity;
import me.mvp.frame.di.component.AppComponent;
import me.mvp.frame.frame.BasePresenter;
import me.mvp.frame.frame.Message;
import me.mvp.frame.http.ResponseCallback;
import retrofit2.Call;

public class LoginPresenter extends BasePresenter<LoginRepository> {

    private AppComponent component;

    private Call<ResponseEntity<User>> login = null;

    public static final int FLAG_LOGIN = 1;

    public LoginPresenter(AppComponent component) {
        super(component.getRepositoryManager().createRepository(LoginRepository.class));

        this.component = component;
    }

    public void login(final Message msg, final String account, final String password) {
        // 回调至实现了ISimpleView接口的showLoading方法，用来显示显示等待框
        msg.getTarget().showLoading();

        // 准备接口开始调用接口请求数据
        login = model.login(account, password);
        login.enqueue(new ResponseCallback<ResponseEntity<User>>() {

            @Override
            protected void onResponse(ResponseEntity<User> body) {
                User user = body.getData();
                if (user != null) {

                    msg.getTarget().showMessage(0, body.getMessage());
                }
            }

            @Override
            protected void onFailure(Throwable throwable) {
                msg.getTarget().showMessage(0, throwable.getMessage());
            }

            @Override
            protected void onFinish(boolean isCanceled) {
                msg.getTarget().hideLoading();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (login != null) {
            login.cancel();
        }
    }
}