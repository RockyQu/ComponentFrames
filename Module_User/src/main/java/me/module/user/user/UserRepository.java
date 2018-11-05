package me.module.user.user;

import me.mvp.frame.frame.IModel;
import me.mvp.frame.integration.IRepositoryManager;

public class UserRepository implements IModel {

    private IRepositoryManager iRepositoryManager;

    public UserRepository(IRepositoryManager iRepositoryManager) {
        this.iRepositoryManager = iRepositoryManager;
    }

    @Override
    public void onDestroy() {

    }
}