package me.module.login.login;

import me.component.service.entity.User;
import me.component.service.entity.base.ResponseEntity;
import me.module.login.app.api.ApiLogin;
import me.mvp.frame.frame.IModel;
import me.mvp.frame.integration.IRepositoryManager;
import retrofit2.Call;

public class LoginRepository implements IModel {

    private IRepositoryManager iRepositoryManager;

    public LoginRepository(IRepositoryManager iRepositoryManager) {
        this.iRepositoryManager = iRepositoryManager;
    }

    public Call<ResponseEntity<User>> login(String username, String password) {
        return iRepositoryManager.createRetrofitService(ApiLogin.class).login(username, password);
    }

    @Override
    public void onDestroy() {

    }
}