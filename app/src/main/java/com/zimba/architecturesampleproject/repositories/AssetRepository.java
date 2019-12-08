package com.zimba.architecturesampleproject.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.zimba.architecturesampleproject.models.Asset;
import com.zimba.architecturesampleproject.models.AssetDao;
import com.zimba.architecturesampleproject.models.AssetDatabase;

import java.util.List;

public class AssetRepository {

    private AssetDao assetDao;
    private LiveData<List<Asset>> allAssets;

    public AssetRepository(Application application) {
        AssetDatabase assetDatabase =
                AssetDatabase.getInstance(application);
        assetDao = assetDatabase.assetDao();
        allAssets = assetDao.getAllAssets();
    }

    public void insertAsset(Asset asset) {
        new InsertAssetAsyncTask(this.assetDao).execute(asset);
    }

    public void updateAsset(Asset asset) {
        new UpdateAssetAsyncTask(this.assetDao).execute(asset);
    }

    public void deleteAsset(Asset asset) {
        new DeleteAssetAsyncTask(this.assetDao).execute(asset);
    }

    public void deleteAllAssets() {
        new DeleteAllAssetsAsyncTask(this.assetDao).execute();
    }

    public LiveData<List<Asset>> getAllAssets() {
        return allAssets;
    }

    private static class InsertAssetAsyncTask extends AsyncTask<Asset, Void, Void> {
        private AssetDao assetDao;

        private InsertAssetAsyncTask(AssetDao assetDao) {
            this.assetDao = assetDao;
        }

        @Override
        protected Void doInBackground(Asset... assets) {
            assetDao.insert(assets[0]);
            return null;
        }
    }

    private static class UpdateAssetAsyncTask extends AsyncTask<Asset, Void, Void> {
        private AssetDao assetDao;

        private UpdateAssetAsyncTask(AssetDao assetDao) {
            this.assetDao = assetDao;
        }

        @Override
        protected Void doInBackground(Asset... assets) {
            assetDao.update(assets[0]);
            return null;
        }
    }

    private static class DeleteAssetAsyncTask extends AsyncTask<Asset, Void, Void> {
        private AssetDao assetDao;

        private DeleteAssetAsyncTask(AssetDao assetDao) {
            this.assetDao = assetDao;
        }

        @Override
        protected Void doInBackground(Asset... assets) {
            assetDao.delete(assets[0]);
            return null;
        }
    }

    private static class DeleteAllAssetsAsyncTask extends AsyncTask<Void, Void, Void> {
        private AssetDao assetDao;

        private DeleteAllAssetsAsyncTask(AssetDao assetDao) {
            this.assetDao = assetDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            assetDao.deleteAllAssets();
            return null;
        }
    }
}
