package me.component.sdk.core.config;

import android.content.Context;

import androidx.room.RoomDatabase;
import me.component.sdk.core.AppConfiguration;
import me.component.sdk.db.AppDatabase;
import me.mvp.frame.db.DatabaseConfig;
import me.mvp.frame.di.module.DBModule;
import me.mvp.frame.utils.AppUtils;

/**
 * 扩展自定义配置数据库参数
 */
public class DBConfig implements DBModule.DBConfiguration {

    @SuppressWarnings("unchecked")
    @Override
    public void configDB(Context context, DatabaseConfig.Builder builder) {
        builder
                .name(AppUtils.getAppChannel(context, AppConfiguration.CHANNEL))
                .databaseClass(AppDatabase.class)
                .allowMainThreadQueries()
        ;
    }

    @Override
    public void createdDB(Context context, RoomDatabase database) {

    }
}