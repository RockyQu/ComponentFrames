package me.component.sdk.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;

import java.lang.reflect.Type;

import me.mvp.frame.di.component.AppComponent;
import me.mvp.frame.utils.AppUtils;

/**
 * 如果你使用 withObject 传值的话需要定义这个类，并实现接口 {@link SerializationService} 在下面三个方法
 * 添加你想支持的自定义 Json 解析，我的项目里没有用到 FastJson，这里我改成了 Gson 的实现
 */
@Route(path = "/service/json")
public class JsonService implements SerializationService {

    private AppComponent component;

    @Override
    public void init(Context context) {
        component = AppUtils.obtainAppComponentFromContext(context);
    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        return component.getGson().fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return component.getGson().toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return component.getGson().fromJson(input, clazz);
    }
}