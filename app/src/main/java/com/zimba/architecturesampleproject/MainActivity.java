package com.zimba.architecturesampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.zimba.architecturesampleproject.models.Asset;
import com.zimba.architecturesampleproject.viewmodels.AssetViewModel;
import com.zimba.architecturesampleproject.views.AssetRecyclerViewAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AssetViewModel assetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycleViewAssets =
                findViewById(R.id.listAssets);
        recycleViewAssets.setLayoutManager(new LinearLayoutManager(this));
        recycleViewAssets.setHasFixedSize(true);

        final AssetRecyclerViewAdapter adapter =
                new AssetRecyclerViewAdapter();
        recycleViewAssets.setAdapter(adapter);

        assetViewModel = ViewModelProviders.of(this).get(
                AssetViewModel.class);
        assetViewModel.getAllAssets().observe(this,
                new Observer<List<Asset>>() {
                    @Override
                    public void onChanged(List<Asset> assets) {
                        //update RecyclerView
                        Toast.makeText(MainActivity.this,
                                "onChanged",
                                Toast.LENGTH_SHORT).show();
                        adapter.submitList(assets);
                    }
                });

        adapter.setOnItemClickListener(new AssetRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(Asset asset) {
                //TODO o que fazer ao clicar
                Toast.makeText(MainActivity.this,
                        "item: "+asset.getTitle()+" clicado",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
