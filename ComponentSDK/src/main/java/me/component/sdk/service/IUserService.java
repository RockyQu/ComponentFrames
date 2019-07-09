package me.component.sdk.service;

import com.alibaba.android.arouter.facade.template.IProvider;

import me.component.sdk.entity.User;

/**
 * 定义业务的抽象接口，需要放在底层，这样其他 Module 才能对该服务进行访问
 */
public interface IUserService extends IProvider {

    /**
     * 传一个 User 过去
     *
     * @param user
     */
    void transferUser(User user);
}