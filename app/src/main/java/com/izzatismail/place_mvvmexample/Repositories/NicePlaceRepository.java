package com.izzatismail.place_mvvmexample.Repositories;

import android.arch.lifecycle.MutableLiveData;

import com.izzatismail.place_mvvmexample.Models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    /* Singleton Pattern  */
    public static NicePlaceRepository getInstance(){
        if(instance == null ){
            instance = new NicePlaceRepository();
        }
        return instance;
    }

    //Mimic getting data from web source
    public MutableLiveData<List<NicePlace>> getNicePlace(){
        setNicePlaces();

        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    //Mimic data retrieval from database
    private void setNicePlaces(){
        dataSet.add(
                new NicePlace("Havasu Falls","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg")
        );
        dataSet.add(
                new NicePlace("Trondheim","https://i.redd.it/tpsnoz5bzo501.jpg")
        );
        dataSet.add(
                new NicePlace("Portugal","https://i.redd.it/qn7f9oqu7o501.jpg")
        );
        dataSet.add(
                new NicePlace("Rocky Mountain National Park","https://i.redd.it/j6myfqglup501.jpg")
        );
        dataSet.add(
                new NicePlace("Mahahual","https://i.redd.it/0h2gm1ix6p501.jpg")
        );
        dataSet.add(
                new NicePlace("Frozen Lake","https://i.redd.it/k98uzl68eh501.jpg")
        );
        dataSet.add(
                new NicePlace("White Sands Desert","https://i.redd.it/glin0nwndo501.jpg")
        );
        dataSet.add(
                new NicePlace("Australia","https://i.redd.it/obx4zydshg601.jpg")
        );
    }
}
