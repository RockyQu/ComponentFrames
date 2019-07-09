package me.module.user.user.fragment;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import me.component.sdk.core.RouterHub;
import me.component.sdk.entity.User;
import me.logg.Logg;
import me.module.user.R;
import me.module.user.R2;
import me.mvp.frame.base.BaseFragment;
import me.mvp.frame.frame.IPresenter;

@Route(path = RouterHub.User.Fragment.USER_FRAGMENT)
public class UserFragment extends BaseFragment{

    @BindView(R2.id.title)
    AppCompatTextView title;
    @BindView(R2.id.message)
    AppCompatTextView message;

    @Autowired
    User user;

    public UserFragment() {

    }

    @Override
    public void create(Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);

        String params = String.format(
                "user = %s",
                component.getGson().toJson(user)
        );

        message.setText(params);
    }

    @OnClick({R2.id.title})
    public void onClick(View v) {
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.remove(this);
        ft.commit();
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

