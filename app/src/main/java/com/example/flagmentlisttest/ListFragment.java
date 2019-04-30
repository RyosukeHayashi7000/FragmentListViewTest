package com.example.flagmentlisttest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.flagmentlisttest.databinding.FragmentListBinding;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;

    public static ListFragment createInstance(){
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final ArrayList<Food> list = new ArrayList<>();
        ListAdapter adapter = new ListAdapter(this.getContext());

        Food food1 = new Food();
        food1.setName("りんご");
        food1.setPrice(100);
        food1.setProducingArea("青森");
        list.add(food1);

        Food food2 = new Food();
        food2.setName("みかん");
        food2.setPrice(500);
        food2.setProducingArea("静岡");
        list.add(food2);

        adapter.notifyDataSetChanged();
        adapter.setFoodList(list);
        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_body,DetailFragment.createInstance(list.get(position).getName(),String.valueOf(list.get(position).getPrice()),list.get(position).getProducingArea()));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }
}
