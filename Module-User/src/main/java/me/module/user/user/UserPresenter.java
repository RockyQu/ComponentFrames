package me.module.user.user;

import me.mvp.frame.di.component.AppComponent;
import me.mvp.frame.frame.BasePresenter;

public class UserPresenter extends BasePresenter<UserRepository> {

    private AppComponent component;

    public UserPresenter(AppComponent component) {
        super(component.getRepositoryManager().createRepository(UserRepository.class));

        this.component = component;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}