package me.component.frame.mvp.main;

import me.mvp.frame.di.component.AppComponent;
import me.mvp.frame.frame.BasePresenter;

public class MainPresenter extends BasePresenter<MainRepository> {

    private AppComponent component;

    public MainPresenter(AppComponent component) {
        super(component.getRepositoryManager().createRepository(MainRepository.class));

        this.component = component;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}