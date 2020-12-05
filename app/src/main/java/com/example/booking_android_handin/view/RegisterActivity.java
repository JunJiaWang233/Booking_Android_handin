package com.example.booking_android_handin.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.booking_android_handin.R;
import com.example.booking_android_handin.databinding.ActivityRegisterBinding;
import com.example.booking_android_handin.viewModel.RegisterViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setRegisterViewModel(registerViewModel);
        binding.setRegisterActivity(this);
        binding.setLifecycleOwner(this);
        registerViewModel= new ViewModelProvider(this).get(RegisterViewModel.class);
    }

    public void createAccount(){
        String email= binding.editTextTextEmailAddress.getText().toString();
        String password= binding.editTextTextPassword.getText().toString();
        registerViewModel.createAccount(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "sign up successful!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}