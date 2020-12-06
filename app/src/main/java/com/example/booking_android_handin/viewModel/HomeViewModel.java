package com.example.booking_android_handin.viewModel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.booking_android_handin.model.Hotel;
import com.example.booking_android_handin.view.HomeActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private DatabaseReference databaseReference;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        databaseReference= FirebaseDatabase.getInstance().getReference();
    }


    public List<Hotel> searchHotel(String location) {
        List<Hotel> hotels= new ArrayList<>();
        databaseReference.child("Hotel").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot sp : snapshot.getChildren()) {
                    Hotel h = sp.getValue(Hotel.class);
                    if (h.getCountry().equals(location)||h.getCity().equals(location)){
                        hotels.add(h);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return hotels;
    }
}
