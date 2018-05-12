package adong.org.finedust;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import adong.org.finedust.data.Dust;
import adong.org.finedust.data.DustList;
import adong.org.finedust.service.APIService;
import adong.org.finedust.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView dataTime;
    private TextView pm10Value;
    private TextView pm25Value;
    private Button dustbutton;

    private final static double VER = 1.3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataTime = findViewById(R.id.dataTime);
        pm10Value = findViewById(R.id.pm10Value);
        pm25Value = findViewById(R.id.pm25Value);
        dustbutton = findViewById(R.id.dustbutton);
        dustbutton.setOnClickListener(this);

    }

    //값 받아와서 쓰기
    void dust(){
        APIService apiService = RetrofitUtil.creatService(APIService.class);
        Call<Dust> call = apiService.getdust("sidoname",1,10,VER);
        call.enqueue(new Callback<Dust>() {
            //연결 성공
            @Override
            public void onResponse(Call<Dust> call, Response<Dust> response) {
                //response.body는 내가 GET한값이 들어있음
                //그래서 밑에 처럼 하면 값을 받아올 수 있음
                Dust dust = response.body();
                //DustList 저장
                List<DustList> dustList = dust.getList();
                dataTime.setText(dustList.get(0).getDataTime());
                pm10Value.setText(dustList.get(0).getPm10Value());
                pm25Value.setText(dustList.get(0).getPm25Value());
            }

            //연결 실패
            @Override
            public void onFailure(Call<Dust> call, Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {
        dust();
    }
}
