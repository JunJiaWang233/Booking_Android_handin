package com.example.booking_android_handin.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;

import com.example.booking_android_handin.R;
import com.example.booking_android_handin.databinding.FragmentHomeBinding;
import com.example.booking_android_handin.viewModel.HomeViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
        binding.setLifecycleOwner(this);
        binding.setHomeViewModel(homeViewModel);
        binding.setHomeFragment(this);

        return binding.getRoot();
    }

    public void searchHotel(){
        String destination= binding.destination.getText().toString();
        Intent intent= new Intent(getContext(), SearchResultActivity.class);
        intent.putExtra("destination", destination);
        startActivity(intent);
    }

    public void checkInTime(){
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            //选择日期点击OK后执行
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(year, monthOfYear, dayOfMonth);
                String strFormat = "yyyy-MM-dd";  //格式设定
                SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
                binding.checkIn.setText(sdf.format(c.getTime())); //设置日期
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void checkOutTime(){
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            //选择日期点击OK后执行
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(year, monthOfYear, dayOfMonth);
                String strFormat = "yyyy-MM-dd";  //格式设定
                SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
                binding.checkOut.setText(sdf.format(c.getTime())); //设置日期
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }
}