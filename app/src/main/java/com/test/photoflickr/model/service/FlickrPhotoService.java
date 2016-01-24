package com.test.photoflickr.model.service;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.test.photoflickr.model.entity.GetSearchPhotoResponse;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

public interface FlickrPhotoService {

    @GET("services/rest/?method=flickr.photos.search")
    Call<GetSearchPhotoResponse> fetchPhotosBy(@Query("text") String text,
                                               @Query("privacy_filter")int privacy_filter,
                                               @Query("page")int page);

    class Factory {

        public static FlickrPhotoService create() {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            OkHttpClient httpClient = new OkHttpClient();

            httpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {

                    Request original = chain.request();
                    String method = original.method();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Content-Type", "application/json")
                            .method(method, original.body());

                    //Add required parameters and helpers params
                    HttpUrl url = original.httpUrl().newBuilder()
                            .addQueryParameter("api_key","0718eccf777b77009392bfc9b0f06bf1")
                            .addQueryParameter("format","json")
                            .addQueryParameter("nojsoncallback","1")//disable the JSONP callback stuff flickr seems to assume we want
                            .build();

                    Request request = requestBuilder.url(url).build();

                    return chain.proceed(request);
                }
            });

            httpClient.interceptors().add(logging);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.flickr.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();

            return retrofit.create(FlickrPhotoService.class);
        }
    }
}