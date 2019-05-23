package com.izzatismail.place_mvvmexample.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.izzatismail.place_mvvmexample.Models.NicePlace;
import com.izzatismail.place_mvvmexample.Repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    //Mutable = Can be indirectly change, unlike LiveData, which can only be observed
    private MutableLiveData<List<NicePlace>> mNicePlace; //Holds Data
    private NicePlaceRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>(); //Represent when a query is made

    public void init(){
        if(mNicePlace != null){
            return;
        }
        mRepo = NicePlaceRepository.getInstance();
        mNicePlace = mRepo.getNicePlace();
    }

    public void addNewValue(final NicePlace nicePlace){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                List<NicePlace> currentPlace = mNicePlace.getValue();
                currentPlace.add(nicePlace);
                mNicePlace.postValue(currentPlace);
                mIsUpdating.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){ return mNicePlace; }

    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
