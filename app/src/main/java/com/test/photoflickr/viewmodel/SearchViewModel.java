package com.test.photoflickr.viewmodel;

import android.content.Context;

import com.test.photoflickr.MyApp;
import com.test.photoflickr.model.entity.GetSearchPhotoResponse;
import com.test.photoflickr.model.entity.Photo_;
import com.test.photoflickr.model.service.FlickrPhotoService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SearchViewModel {

    private Context context;
    private SearchPhotoListener searchPhotoListener;

    public SearchViewModel(Context context, SearchPhotoListener searchPhotoListener){
        this.context = context;
        this.searchPhotoListener = searchPhotoListener;
    }

    public void searchPhotoByWord(String world, int pagerNumber){

        MyApp application = MyApp.get(this.context);
        FlickrPhotoService flickrPhoto = application.getFlickrService();

        Call<GetSearchPhotoResponse> call = flickrPhoto.fetchPhotosBy(world, 1, pagerNumber);

        call.enqueue(new Callback<GetSearchPhotoResponse>() {
            @Override
            public void onResponse(Response<GetSearchPhotoResponse> response, Retrofit retrofit) {

                List<Photo_> photos = response.body().getPhotos().getPhoto();
                SearchViewModel.this.searchPhotoListener.onSearchResult(photos);
            }

            @Override
            public void onFailure(Throwable t) {
                SearchViewModel.this.searchPhotoListener.onSearchError();
            }
        });
    }

    public interface SearchPhotoListener{
        void onSearchResult(List<Photo_> photos);
        void onSearchError();
    }
}