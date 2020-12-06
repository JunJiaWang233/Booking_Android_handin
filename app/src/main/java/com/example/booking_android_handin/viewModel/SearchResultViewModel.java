package com.example.booking_android_handin.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.booking_android_handin.model.Hotel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchResultViewModel extends AndroidViewModel {

    private DatabaseReference databaseReference;
    private MutableLiveData<List<Hotel>> hotels= new MutableLiveData<>();
    private List<Hotel> hs;



    public SearchResultViewModel(@NonNull Application application) {
        super(application);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        hs= new ArrayList<>();
        hotels.setValue(hs);
        getAllHotels();
    }

//    public List<Hotel> searchHotel(String location) {
//        Log.w("www", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        List<Hotel> hotels= new ArrayList<>();
//        databaseReference.child("Hotel").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("success", "data change");
//                for (DataSnapshot sp : snapshot.getChildren()) {
//                    Hotel h = sp.getValue(Hotel.class);
//                    if (h.getCountry().equals(location)||h.getCity().equals(location)){
//                        hotels.add(h);
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.d("failed", "error");
//            }
//        });
//
//        return hotels;
//    }

    public void getAllHotels(){

        databaseReference.child("Hotel").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){
                  hotels.getValue().add(ds.getValue(Hotel.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
            }
        });

    }

    public MutableLiveData<List<Hotel>> getHotels() {
        return hotels;
    }
}
