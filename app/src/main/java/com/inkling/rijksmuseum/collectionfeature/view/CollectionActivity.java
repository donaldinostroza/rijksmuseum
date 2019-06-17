package com.inkling.rijksmuseum.collectionfeature.view;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.inkling.rijksmuseum.R;
import com.inkling.rijksmuseum.collectionfeature.repository.ArtObjectsResponse;
import com.inkling.rijksmuseum.collectionfeature.repository.RetrofitClientInstance;
import com.inkling.rijksmuseum.collectionfeature.repository.RijksmuseumDataSource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionActivity extends AppCompatActivity {


    private ArtCollectionAdapter adapter;
    private RecyclerView collectionListRV;
    ProgressDialog progressDoalog;

    private final static String API_KEY = "wi6eA3Yp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressDoalog = new ProgressDialog(CollectionActivity.this);
        progressDoalog.setMessage("Loading Collection...");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        RijksmuseumDataSource service = RetrofitClientInstance.getRetrofitInstance().create(RijksmuseumDataSource.class);
        Call<ArtObjectsResponse> call = service.getArtObjectsByMaker(API_KEY, "Picasso", "0", "50");
        call.enqueue(new Callback<ArtObjectsResponse>() {
            @Override
            public void onResponse(Call<ArtObjectsResponse> call, Response<ArtObjectsResponse> response) {
                progressDoalog.dismiss();
                if(response.body() != null){
                    showCollection(response.body());
                } else{
                    showError();
                }
            }

            @Override
            public void onFailure(Call<ArtObjectsResponse> call, Throwable t) {
                progressDoalog.dismiss();
                showError();
            }
        });
    }

    private void showCollection(ArtObjectsResponse response) {
        collectionListRV = findViewById(R.id.collectionList);
        adapter = new ArtCollectionAdapter(this, response.getArtObjects());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CollectionActivity.this);
        collectionListRV.setLayoutManager(layoutManager);
        collectionListRV.setAdapter(adapter);
    }

    private void showError(){
        Toast.makeText(CollectionActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }

}
