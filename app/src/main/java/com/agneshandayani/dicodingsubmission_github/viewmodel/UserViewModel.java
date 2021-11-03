package com.agneshandayani.dicodingsubmission_github.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.agneshandayani.dicodingsubmission_github.api.ApiClient;
import com.agneshandayani.dicodingsubmission_github.api.ApiInterface;
import com.agneshandayani.dicodingsubmission_github.model.ModelFollow;
import com.agneshandayani.dicodingsubmission_github.model.ModelSearch;
import com.agneshandayani.dicodingsubmission_github.model.ModelSearchData;
import com.agneshandayani.dicodingsubmission_github.model.ModelUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {

    public MutableLiveData<ArrayList<ModelSearchData>> modelSearchMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<ModelFollow>> modelFollowersMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<ModelFollow>> modelFollowingMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<ModelUser> modelUserMutableLiveData = new MutableLiveData<>();
    public static String strApiKey = "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";

    //method search user
    public void setSearchUser(String query) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ModelSearch> call = apiService.searchUser(strApiKey, query);
        call.enqueue(new Callback<ModelSearch>() {
            @Override
            public void onResponse(Call<ModelSearch> call, Response<ModelSearch> response) {
                if (!response.isSuccessful()) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    ArrayList<ModelSearchData> items = new ArrayList<>(response.body().getModelSearchData());
                    modelSearchMutableLiveData.setValue(items);
                }
            }

            @Override
            public void onFailure(Call<ModelSearch> call, Throwable t) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method view detail user
    public void setUserDetail(String strUsername) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ModelUser> call = apiService.detailUser(strUsername);
        call.enqueue(new Callback<ModelUser>() {

            @Override
            public void onResponse(Call<ModelUser> call, Response<ModelUser> response) {
                if (!response.isSuccessful()) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    modelUserMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ModelUser> call, Throwable t) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method get followers
    public void setFollowersUser(String strUsername) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<ModelFollow>> call = apiService.followersUser(strApiKey, strUsername);
        call.enqueue(new Callback<List<ModelFollow>>() {
            @Override
            public void onResponse(Call<List<ModelFollow>> call, Response<List<ModelFollow>> response) {
                if (!response.isSuccessful()) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    modelFollowersMutableLiveData.setValue(response.body());
                }
            }

            public void onFailure(Call<List<ModelFollow>> call, Throwable t) {
                Log.e("failure", t.toString());
            }
        });
    }

    //method get following
    public void setFollowingUser(String strUsername) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<ModelFollow>> call = apiService.followingUser(strApiKey, strUsername);
        call.enqueue(new Callback<List<ModelFollow>>() {
            public void onResponse(Call<List<ModelFollow>> call, Response<List<ModelFollow>> response) {
                if (!response.isSuccessful()) {
                    Log.e("response", response.toString());
                } else if (response.body() != null) {
                    modelFollowingMutableLiveData.setValue(response.body());
                }
            }

            public void onFailure(Call<List<ModelFollow>> call, Throwable t) {
                Log.e("failure", t.toString());
            }
        });
    }

    public LiveData<ArrayList<ModelSearchData>> getResultList() {
        return modelSearchMutableLiveData;
    }

    public LiveData<ModelUser> getUserList() {
        return modelUserMutableLiveData;
    }

    public LiveData<List<ModelFollow>> getFollowersUser() {
        return modelFollowersMutableLiveData;
    }

    public LiveData<List<ModelFollow>> getFollowingUser() {
        return modelFollowingMutableLiveData;
    }

}