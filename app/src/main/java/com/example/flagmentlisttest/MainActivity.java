package com.example.flagmentlisttest;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.flagmentlisttest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private String name;
    private String comment;
    private ActivityMainBinding binding;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_body, ListFragment.createInstance());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



    }
}
