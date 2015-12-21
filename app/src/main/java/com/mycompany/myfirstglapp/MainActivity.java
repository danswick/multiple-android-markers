package com.mycompany.myfirstglapp;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.Sprite;
import com.mapbox.mapboxsdk.annotations.SpriteFactory;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

public class MainActivity extends AppCompatActivity {

    private MapView mapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Create a mapView and give it some properties */
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setStyleUrl(Style.MAPBOX_STREETS);
        mapView.setCenterCoordinate(new LatLng(41.885, -87.679));
        mapView.setZoomLevel(9);

        /** Use SpriteFactory, Drawable, and Sprite to load our marker icon
         * and assign it to a marker */
        SpriteFactory spriteFactory = mapView.getSpriteFactory();
        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.dot_auto);
        Sprite icon = spriteFactory.fromDrawable(drawable);

        Drawable secondDrawable = ContextCompat.getDrawable(this, R.mipmap.ic_directions_bike_black_24dp);
        Sprite secondIcon = spriteFactory.fromDrawable(secondDrawable);

        mapView.addMarker(new MarkerOptions()
                .position(new LatLng(41.885, -87.679))
                .title("Hello World!")
                .snippet("Welcome to my marker.")
                .icon(icon));

        mapView.addMarker(new MarkerOptions()
                .position(new LatLng(41.885, -87.879))
                .title("I'm a second marker")
                .icon(secondIcon));

        mapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause()  {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
