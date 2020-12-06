package com.example.booking_android_handin.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.booking_android_handin.R;
import com.example.booking_android_handin.databinding.ActivitySearchResultBinding;
import com.example.booking_android_handin.model.Hotel;
import com.example.booking_android_handin.viewModel.SearchResultViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {
    
    ActivitySearchResultBinding binding;
    SearchResultViewModel searchResultViewModel;
    String destination;
    HotelAdapter hotelAdapter;
    List<Hotel> hs= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_search_result);
        binding.setLifecycleOwner(this);
        searchResultViewModel= new ViewModelProvider(this).get(SearchResultViewModel.class);




        binding.hotelList.hasFixedSize();
        binding.hotelList.setLayoutManager(new LinearLayoutManager(this));
        searchResultViewModel.getHotels().observe(this, new Observer<List<Hotel>>() {
            @Override
            public void onChanged(List<Hotel> hotels) {
               hs= hotels;
               Log.e("01", hs.toString());
            }
        });

        hotelAdapter= new HotelAdapter(hs);
        binding.hotelList.setAdapter(hotelAdapter);
    }
    
//    public ArrayList<Hotel> searchHotel(){
//        Intent intent= getIntent();
//        destination= intent.getStringExtra("destination");
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        Log.w("www", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        List<Hotel> hotels = searchResultViewModel.searchHotel(destination);
//        ArrayList<Hotel> hs= (ArrayList<Hotel>)hotels;
//        return hs;
//    }


}