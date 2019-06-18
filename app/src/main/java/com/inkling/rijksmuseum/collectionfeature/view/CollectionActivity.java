package com.inkling.rijksmuseum.collectionfeature.view;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.inkling.rijksmuseum.R;
import com.inkling.rijksmuseum.collectionfeature.CollectionInterface;
import com.inkling.rijksmuseum.collectionfeature.presenter.CollectionPresenter;
import com.inkling.rijksmuseum.collectionfeature.repository.ArtObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class CollectionActivity extends AppCompatActivity implements CollectionInterface.View {


    private CollectionPresenter presenter;
    private ArtCollectionAdapter adapter;
    private RecyclerView collectionListRV;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new CollectionPresenter(this);

        loadUI();
    }

    private void loadUI() {
        presenter.getCollection();

        progressDialog = new ProgressDialog(CollectionActivity.this);
        progressDialog.setMessage("Loading Collection...");
        progressDialog.show();

        collectionListRV = findViewById(R.id.collectionList);

    }

    @Override
    public void showCollection(ArrayList<ArtObject> artObject) {
        progressDialog.dismiss();

        if(adapter == null) {
            adapter = new ArtCollectionAdapter(artObject);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CollectionActivity.this);
            collectionListRV.setLayoutManager(layoutManager);
            collectionListRV.setAdapter(adapter);
        } else{
            adapter.setData(artObject);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showError(){
        progressDialog.dismiss();
        Toast.makeText(CollectionActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_collection, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) search.getActionView();
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.show();
                presenter.getCollectionByMaker(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });
    }

}
