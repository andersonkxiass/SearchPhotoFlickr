package com.test.photoflickr;

import android.app.Application;
import android.content.Context;

import com.test.photoflickr.model.service.FlickrPhotoService;


/**
 * Created by andersonacs on 22/01/16.
 */
public class MyApp extends Application {

    private FlickrPhotoService flickrService;

    public static MyApp get(Context context) {
        return (MyApp) context.getApplicationContext();
    }

    public FlickrPhotoService getFlickrService() {
        if (flickrService == null) {
            flickrService = FlickrPhotoService.Factory.create();
        }
        return flickrService;
    }

    //For setting mocks during testing
    public void setFlickrService(FlickrPhotoService flickrService) {
        this.flickrService = flickrService;
    }
}