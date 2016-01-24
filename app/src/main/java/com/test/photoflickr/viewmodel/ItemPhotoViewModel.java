package com.test.photoflickr.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.test.photoflickr.R;
import com.test.photoflickr.model.entity.Photo_;
import com.test.photoflickr.view.activity.PhotoDetailActivity;

/**
 * Created by andersonacs on 23/01/16.
 */
public class ItemPhotoViewModel extends BaseObservable {

    private Photo_ photo;
    private Context context;

    public ItemPhotoViewModel(Context context, Photo_ photo){
        this.context = context;
        this.photo = photo;
    }

    public void onItemClick(View view) {
        context.startActivity(PhotoDetailActivity.newIntent(context, photo));
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .centerCrop()
                .placeholder(R.mipmap.placeholder_photo)
                //.override(600, 400)
                .dontAnimate()
                .priority(Priority.HIGH )
                .into(view);
    }

    public void setPhoto(Photo_ photo){
        this.photo = photo;
        notifyChange();
    }

    public Photo_ getPhoto(){
        return this.photo;
    }
}