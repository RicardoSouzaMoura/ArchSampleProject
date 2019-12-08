package com.zimba.architecturesampleproject.models;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Asset.class}, version = 1)
public abstract class AssetDatabase extends RoomDatabase {

    private static AssetDatabase instance;

    public abstract AssetDao assetDao();

    public static synchronized AssetDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AssetDatabase.class, "asset_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomDatabaseCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private AssetDao assetDao;

        public PopulateDbAsyncTask(AssetDatabase assetDb) {
            this.assetDao = assetDb.assetDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            this.assetDao.insert(new Asset("Ativo 1",
                    "Caixa de agua"));
            this.assetDao.insert(new Asset("Ativo 2",
                    "Caixa de passagem"));
            this.assetDao.insert(new Asset("Ativo 3",
                    "Caixa de maquiagem"));
            this.assetDao.insert(new Asset("Ativo 4",
                    "Caixa de ferramenta"));
            this.assetDao.insert(new Asset("Ativo 5",
                    "Caixa de fios"));
            this.assetDao.insert(new Asset("Ativo 6",
                    "Caixa de pregos"));
            this.assetDao.insert(new Asset("Ativo 7",
                    "Caixa de porcas"));
            this.assetDao.insert(new Asset("Ativo 8",
                    "Caixa de tintas"));
            this.assetDao.insert(new Asset("Ativo 9",
                    "Caixa de pinceis"));
            this.assetDao.insert(new Asset("Ativo 10",
                    "Caixa de britadeiras"));
            this.assetDao.insert(new Asset("Ativo 11",
                    "Caixa de cimento"));

            this.assetDao.insert(new Asset("Ativo 1",
                    "Caixa de agua"));
            this.assetDao.insert(new Asset("Ativo 2",
                    "Caixa de passagem"));
            this.assetDao.insert(new Asset("Ativo 3",
                    "Caixa de maquiagem"));
            this.assetDao.insert(new Asset("Ativo 4",
                    "Caixa de ferramenta"));
            this.assetDao.insert(new Asset("Ativo 5",
                    "Caixa de fios"));
            this.assetDao.insert(new Asset("Ativo 6",
                    "Caixa de pregos"));
            this.assetDao.insert(new Asset("Ativo 7",
                    "Caixa de porcas"));
            this.assetDao.insert(new Asset("Ativo 8",
                    "Caixa de tintas"));
            this.assetDao.insert(new Asset("Ativo 9",
                    "Caixa de pinceis"));
            this.assetDao.insert(new Asset("Ativo 10",
                    "Caixa de britadeiras"));
            this.assetDao.insert(new Asset("Ativo 11",
                    "Caixa de cimento"));
            return null;
        }
    }

}
