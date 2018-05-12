package adong.org.finedust.service;

import adong.org.finedust.data.Dust;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET(URLService.geturl + URLService.servicekey + "&_returnType=json")
    Call<Dust> getdust(@Query("sidoName") String sidoName, @Query("pageNo") int pageNo,
                       @Query("numOfRows") int numOfRows, @Query("ver") double ver);

}
