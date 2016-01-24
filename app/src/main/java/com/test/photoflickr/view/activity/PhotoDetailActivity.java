package com.test.photoflickr.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.test.photoflickr.R;
import com.test.photoflickr.model.entity.Photo_;
import com.test.photoflickr.view.fragments.PhotoDetailActivityFragment;

public class PhotoDetailActivity extends AppCompatActivity {

    PhotoDetailActivityFragment fragment;

    public static final String EXTRA_PHOTO = "EXTRA_PHOTO";

    public static Intent newIntent(Context context, Photo_ photo) {
        Intent intent = new Intent(context, PhotoDetailActivity.class);
        intent.putExtra(EXTRA_PHOTO, photo);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }

        Bundle bundle = getIntent().getExtras();

        fragmentSetup(bundle);
    }

    private void fragmentSetup(Bundle bundle){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(fragmentManager.findFragmentById(R.id.fragment) == null){

            fragment = new PhotoDetailActivityFragment();
            fragment.setArguments(bundle);
            fragmentTransaction.add(R.id.fragment, fragment);
            fragmentTransaction.commit ();
        }
    }
}