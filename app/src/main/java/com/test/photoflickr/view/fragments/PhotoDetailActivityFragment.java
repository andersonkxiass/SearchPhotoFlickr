package com.test.photoflickr.view.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.test.photoflickr.R;
import com.test.photoflickr.model.entity.Photo_;
import com.test.photoflickr.view.activity.PhotoDetailActivity;

import uk.co.senab.photoview.PhotoView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PhotoDetailActivityFragment extends Fragment {

    private Photo_ photo;

    public PhotoDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_photo_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        photo = (Photo_)getArguments().getSerializable(PhotoDetailActivity.EXTRA_PHOTO);

        PhotoView photoView = (PhotoView) view.findViewById(R.id.iv_photo);
        photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        Glide.with(view.getContext())
                .load(photo.getUrl())
                .placeholder(R.mipmap.placeholder_photo)
                .priority(Priority.HIGH )
                .into(photoView);
    }
}