package com.zimba.architecturesampleproject.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zimba.architecturesampleproject.models.Asset;
import com.zimba.architecturesampleproject.repositories.AssetRepository;

import java.util.List;

public class AssetViewModel extends AndroidViewModel {

    private AssetRepository assetRepository;
    private LiveData<List<Asset>> allAssets;


    public AssetViewModel(@NonNull Application application) {
        super(application);
        assetRepository = new AssetRepository(application);
        allAssets = assetRepository.getAllAssets();
    }

    public void insertAsset(Asset asset){
        assetRepository.insertAsset(asset);
    }

    public void updateAsset(Asset asset){
        assetRepository.updateAsset(asset);
    }

    public void deleteAsset(Asset asset){
        assetRepository.deleteAsset(asset);
    }

    public void deleteAllAssets(){
        assetRepository.deleteAllAssets();
    }

    public LiveData<List<Asset>> getAllAssets(){
        return allAssets;
    }
}
