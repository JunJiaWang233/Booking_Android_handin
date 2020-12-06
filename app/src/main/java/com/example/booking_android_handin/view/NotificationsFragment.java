package com.example.booking_android_handin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.booking_android_handin.R;
import com.example.booking_android_handin.databinding.FragmentNotificationsBinding;
import com.example.booking_android_handin.viewModel.NotificationsViewModel;
import com.google.firebase.auth.FirebaseUser;


public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;
    private FirebaseUser currentUser;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_notifications, container, false );
        binding.setLifecycleOwner(this);
        binding.setNotificationsFragment(this);

        currentUser= notificationsViewModel.getFirebaseAuth().getCurrentUser();

        return binding.getRoot();
    }




    public void logOut(){
        Intent intent= new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }
}