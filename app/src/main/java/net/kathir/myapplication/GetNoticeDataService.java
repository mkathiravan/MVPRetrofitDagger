package net.kathir.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GetNoticeDataService {

    @GET("api/v1/employees")
    Call<List<Employee>> getNoticeData();


}
