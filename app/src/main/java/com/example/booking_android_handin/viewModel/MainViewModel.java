package com.example.booking_android_handin.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainViewModel extends AndroidViewModel {


    private FirebaseAuth firebaseAuth;



    public MainViewModel(@NonNull Application application) {
        super(application);
        firebaseAuth= FirebaseAuth.getInstance();
    }


    public Task<AuthResult> signIn(String email, String password){
        Task<AuthResult> authResultTask = firebaseAuth.signInWithEmailAndPassword(email, password);
        return authResultTask;
    }
}
