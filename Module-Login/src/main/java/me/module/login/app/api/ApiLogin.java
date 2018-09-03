package me.module.login.app.api;

import me.component.sdk.entity.User;
import me.component.sdk.entity.base.ResponseEntity;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiLogin {

    @FormUrlEncoded
    @POST("index.php?m=member&c=api&a=do_login")
    Call<ResponseEntity<User>> login(@Field("username") String username, @Field("password") String password);
}