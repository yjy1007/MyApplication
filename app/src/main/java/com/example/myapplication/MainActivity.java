package com.example.myapplication;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    String  url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //todo  创建OkHttpClient客户端对象
//        OkHttpClient client = new OkHttpClient();
//        //todo  设置请求建造者
//        Request.Builder builder = new Request.Builder();
//        //todo  设置URL  请求方式
//        Request request = builder.url(url).get().build();
//        //todo  客户端调用
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println("onFailure:"+e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.i("onSuccess",response.body().string());
//            }
//        });

        //todo  上传文件
        Retrofit retrofit = new Retrofit.Builder().baseUrl("").build();
        MyService myService = retrofit.create(MyService.class);
        File directory = Environment.getExternalStorageDirectory();
        String   child = "/pictures/a.jpg";
        File file = new File(directory,child);
        MediaType parse = MediaType.parse("Application/otcet-stream");
        RequestBody requestBody = RequestBody.create(parse,file);
        MultipartBody.Part part = MultipartBody.Part.create(requestBody);
        retrofit2.Call<ResponseBody> bodyMthod = myService.getBodyMthod(part);
        bodyMthod.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
