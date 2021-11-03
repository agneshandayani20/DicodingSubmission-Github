package com.agneshandayani.dicodingsubmission_github.api;

import com.agneshandayani.dicodingsubmission_github.model.ModelFollow;
import com.agneshandayani.dicodingsubmission_github.model.ModelSearch;
import com.agneshandayani.dicodingsubmission_github.model.ModelUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("users/{username}")
    Call<ModelUser> detailUser(@Path("username") String username);

    @GET("/search/users")
    Call<ModelSearch> searchUser(@Header("Authorization") String authorization,
                                 @Query("q") String username);

    @GET("users/{username}/followers")
    Call<List<ModelFollow>> followersUser(@Header("Authorization") String authorization,
                                          @Path("username") String username);

    @GET("users/{username}/following")
    Call<List<ModelFollow>> followingUser(@Header("Authorization") String authorization,
                                          @Path("username") String username);

}