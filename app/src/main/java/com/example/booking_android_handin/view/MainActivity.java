package com.example.booking_android_handin.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.booking_android_handin.R;
import com.example.booking_android_handin.databinding.ActivityMainBinding;
import com.example.booking_android_handin.model.Hotel;
import com.example.booking_android_handin.viewModel.MainViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
        binding.setMainViewModel(mainViewModel);
        binding.setLifecycleOwner(this);
        mainViewModel= new ViewModelProvider(this).get(MainViewModel.class);
    }

    public void intentToRegister(){
        Intent intent= new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void intentToHome(){
        Intent intent= new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }


    public void signIn(){
        String email= binding.editTextTextEmailAddress.getText().toString();
        String password= binding.editTextTextPassword.getText().toString();
        mainViewModel.signIn(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("signIn", "createUserWithEmail:success");
                            intentToHome();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SignIn", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    public void databaseTest(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Hotel h1= new Hotel("h1", "Denmark");
        Hotel h2= new Hotel("h2", "Denmark");
        Hotel h3= new Hotel("h3", "Denmark");
        Hotel h4= new Hotel("h4", "Germany");
        Hotel h5= new Hotel("h5", "Germany");
        Hotel h6= new Hotel("h6", "France");
        Hotel h7= new Hotel("h7", "France");
        List<Hotel> hotels= new ArrayList<>();
        hotels.add(h1);
        hotels.add(h2);
        hotels.add(h3);
        hotels.add(h4);
        hotels.add(h5);
        hotels.add(h6);
        hotels.add(h7);
        myRef.child("Hotel").setValue(hotels);
    }
}