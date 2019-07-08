package me.component.sdk.entity;

import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 用户信息
 */
@Entity(tableName = "User")
public class User {

    @PrimaryKey(autoGenerate = true)
    int id;

    // ID
    @SerializedName("userId")
    String userId;

    // 名字
    @ColumnInfo(name = "name")
    String name;

    public User() {

    }

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}