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
    private int id;

    // ID
    @SerializedName("userId")
    private String userId;

    // 名字
    @ColumnInfo(name = "name")
    private String name;

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