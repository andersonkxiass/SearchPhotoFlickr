package com.test.photoflickr.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.test.photoflickr.model.entity.Photo_;

/**
 * Created by andersonacs on 24/01/16.
 */
public class PhotoViewModel extends BaseObservable {

    private Photo_ photo;
    private Context context;

    public PhotoViewModel(Context context, Photo_ photo){
        this.context = context;
        this.photo = photo;
    }
}
