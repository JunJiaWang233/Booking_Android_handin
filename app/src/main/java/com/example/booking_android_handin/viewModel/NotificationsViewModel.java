package com.example.booking_android_handin.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class NotificationsViewModel extends ViewModel {

   private FirebaseAuth firebaseAuth;

    public NotificationsViewModel() {
       firebaseAuth= FirebaseAuth.getInstance();
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }
}