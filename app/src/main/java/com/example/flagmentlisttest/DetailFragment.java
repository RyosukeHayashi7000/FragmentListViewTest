package com.example.flagmentlisttest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flagmentlisttest.databinding.DetailFragmentBinding;

public class DetailFragment extends Fragment {

    public final static String NAME = "key_name1";
    public final static String PRICE = "key_name2";
    public final static String PLACE = "key_name3";
    private DetailFragmentBinding binding;

    @CheckResult
    public static DetailFragment createInstance(String name, String price, String place) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(NAME,name);
        args.putString(PRICE,price);
        args.putString(PLACE,place);
        fragment.setArguments(args);
        return fragment;

    }

    private String mName;
    private String mPrice;
    private String mPlace;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        if (args != null) {
            mName = args.getString(NAME);
            mPrice = args.getString(PRICE);
            mPlace = args.getString(PLACE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.textView.setText("農産物: " + mName);
        binding.textView2.setText("価格: " + mPrice + "円");
        binding.textView3.setText("生産地: " + mPlace);
    }
}
