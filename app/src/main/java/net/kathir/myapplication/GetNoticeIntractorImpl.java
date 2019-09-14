package net.kathir.myapplication;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNoticeIntractorImpl implements MainContract.GetNoticeIntractor {

    private static final String TAG = GetNoticeIntractorImpl.class.getSimpleName();

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {


        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        Call<List<Employee>> call = service.getNoticeData();

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {

                Log.d(TAG,"EMPLOYEE_LIST "+ response.body());
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

                onFinishedListener.onFailure(t);
            }
        });

    }
}
