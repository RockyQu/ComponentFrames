package me.component.sdk.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import me.component.sdk.entity.User;
import me.mvp.frame.di.component.AppComponent;

/**
 * 数据库
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase get(AppComponent component) {
        return (AppDatabase) component.dbManager().database();
    }
}