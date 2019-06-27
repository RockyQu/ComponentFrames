package me.component.sdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 用户信息
 */
@Entity(tableName = "User")
public class User implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    // ID
    @SerializedName("userId")
    private String userId;

    // 名字
    @ColumnInfo(name = "name")
    private String name;

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

    @Override
    public int describeContents() {
        return 0;
    }

    public User(Parcel in) {
        this.id = in.readInt();
        this.userId = in.readString();
        this.name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(userId);
        dest.writeString(name);
    }

    public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}