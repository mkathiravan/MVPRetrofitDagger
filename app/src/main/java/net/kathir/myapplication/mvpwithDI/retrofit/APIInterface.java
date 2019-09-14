package net.kathir.myapplication.mvpwithDI.retrofit;



import net.kathir.myapplication.mvpwithDI.pojo.CryptoData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {

    @GET("ticker/?")
    Observable<List<CryptoData>> getData(@Query("limit") String limit);
}
