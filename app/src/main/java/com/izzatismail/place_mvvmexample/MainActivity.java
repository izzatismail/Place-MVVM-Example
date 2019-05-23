package com.izzatismail.place_mvvmexample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.izzatismail.place_mvvmexample.Adapters.RecyclerAdapter;
import com.izzatismail.place_mvvmexample.Models.NicePlace;
import com.izzatismail.place_mvvmexample.ViewModels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;
    private MainActivityViewModel mMainActivityVM;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        initWidgets();

        mMainActivityVM = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityVM.init();

        //To observe changes done to the LiveData objects
        mMainActivityVM.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(@Nullable List<NicePlace> nicePlaces) {
                mAdapter.notifyDataSetChanged();
            }
        });

        mMainActivityVM.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean) {
                    showProgressBar();
                }else{
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(mMainActivityVM.getNicePlaces().getValue().size()-1);
                }
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivityVM.addNewValue(
                        new NicePlace( "Washington","https://i.imgur.com/ZcLLrkY.jpg")
                );
            }
        });

        initRecyclerView();
    }

    private void initWidgets() {
        mFab = findViewById(R.id.floatingAB);
        mRecyclerView = findViewById(R.id.place_recycler);
        mProgressBar = findViewById(R.id.progress_circular);
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        mAdapter = new RecyclerAdapter(this, mMainActivityVM.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showProgressBar() { mProgressBar.setVisibility(View.VISIBLE); }

    private void hideProgressBar() { mProgressBar.setVisibility(View.GONE); }

}
