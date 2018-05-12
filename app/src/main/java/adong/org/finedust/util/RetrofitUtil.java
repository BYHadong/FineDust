package adong.org.finedust.util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private final static String BASE_URL = "http://openapi.airkorea.or.kr/";

    private static OkHttpClient.Builder httpbuilder = new OkHttpClient .Builder();
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();

    public static <S> S creatService(Class<S> serviceClass){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpbuilder.addInterceptor(interceptor);
        builder.client(httpbuilder.build());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }



}
