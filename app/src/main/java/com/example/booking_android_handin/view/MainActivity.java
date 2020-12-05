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
import com.example.booking_android_handin.viewModel.MainViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
                            Toast.makeText(MainActivity.this, "Successful!",
                                    Toast.LENGTH_SHORT).show();
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
}