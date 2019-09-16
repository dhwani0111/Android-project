package com.example.maps1;

import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Toast.makeText(MapsActivity.this,location.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        LatLng Charusat = new LatLng(22.599589,72.8205);
        mMap.addMarker(new MarkerOptions().position(Charusat).title("I love Charusat"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Charusat, 18));
        LatLng hospital = new LatLng(22.6024825,72.8211926);
        mMap.addMarker(new MarkerOptions().position(hospital).title("hospital").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Cspit = new LatLng(22.6001922,72.8176969);
        mMap.addMarker(new MarkerOptions().position(Cspit).title("CE/IT").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Civil = new LatLng(22.599589,72.818306);
        mMap.addMarker(new MarkerOptions().position(Civil).title("Civil/Mech/Cspit").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng Ec = new LatLng(22.5998321,72.8176915);
        mMap.addMarker(new MarkerOptions().position(Ec).title("EC/EE").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng bca = new LatLng(22.6032978,72.8161946);
        mMap.addMarker(new MarkerOptions().position(bca).title("BCA/MCA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        LatLng pdpis = new LatLng(22.6016527,72.8174767);
        mMap.addMarker(new MarkerOptions().position(pdpis).title("PDPIS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        LatLng mba = new LatLng(22.5998024,72.8184425);
        mMap.addMarker(new MarkerOptions().position(mba).title("I2IM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(Civil,Cspit)
                .width(5)
                .color(Color.RED));

    }
}
