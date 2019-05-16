package com.izzatismail.place_mvvmexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.izzatismail.place_mvvmexample.Adapters.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //Vars
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImageURI = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");


        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageURI.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mImageNames.add("Havasu Falls");

        mImageURI.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mImageNames.add("Trondheim");

        mImageURI.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mImageNames.add("Portugal");

        mImageURI.add("https://i.redd.it/j6myfqglup501.jpg");
        mImageNames.add("Rocky Mountain National Park");


        mImageURI.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mImageNames.add("Mahahual");

        mImageURI.add("https://i.redd.it/k98uzl68eh501.jpg");
        mImageNames.add("Frozen Lake");


        mImageURI.add("https://i.redd.it/glin0nwndo501.jpg");
        mImageNames.add("White Sands Desert");

        mImageURI.add("https://i.redd.it/obx4zydshg601.jpg");
        mImageNames.add("Austrailia");

        mImageURI.add("https://i.imgur.com/ZcLLrkY.jpg");
        mImageNames.add("Washington");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.place_recycler);
        RecyclerAdapter adapter = new RecyclerAdapter(this, mImageNames, mImageURI);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
