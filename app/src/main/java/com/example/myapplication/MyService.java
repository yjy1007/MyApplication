package com.example.myapplication;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface MyService {
    @Multipart
    @POST("http://1.z9ls.com/upload.php")
    Call<ResponseBody>  getBodyMthod(@Part MultipartBody.Part  file);
}
