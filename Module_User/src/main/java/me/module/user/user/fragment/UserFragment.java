package me.module.user.user.fragment;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import me.component.sdk.core.RouterHub;
import me.component.sdk.entity.User;
import me.logg.Logg;
import me.module.user.R;
import me.mvp.frame.base.BaseFragment;
import me.mvp.frame.frame.IPresenter;

@Route(path = RouterHub.User.Fragment.USER_FRAGMENT)
public class UserFragment extends BaseFragment {

    @Autowired
    User user;

    public UserFragment() {

    }

    @Override
    public void create(Bundle savedInstanceState) {
        Logg.e("BlankFragment");
    }

    @Override
    public IPresenter obtainPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user;
    }
}

