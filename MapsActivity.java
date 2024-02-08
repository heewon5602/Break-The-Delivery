package com.example.breakthedelivery;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.breakthedelivery.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double[] latitude= {37.453099, 37.453644, 37.454189};
        double[] longitude = {127.128332, 127.127549, 127.128246};

        double sumLatitude = 0;
        double sumLongitude = 0;
        double avgLatitude = 0;
        double avgLongitude = 0;

        //최대 6개의 집에 배달 간다고 가정
        for (int idx = 0; idx < 3; idx++) {
            // 1. 마커 옵션 설정 (만드는 과정)
            MarkerOptions makerOptions = new MarkerOptions();
            makerOptions // LatLng에 대한 어레이를 만들어서 이용할 수도 있다.
                    .position(new LatLng(latitude[idx], longitude[idx]))
                    .title("배달지" + idx+1); // 타이틀.

            // 2. 마커 생성 (마커를 나타냄)
            mMap.addMarker(makerOptions);

            sumLatitude+=latitude[idx];
            sumLongitude+=longitude[idx];
        }

        avgLatitude = sumLatitude/3;
        avgLongitude = sumLongitude/3;

        // 카메라를 위치로 옮긴다.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(avgLatitude, avgLongitude)));
    }
}