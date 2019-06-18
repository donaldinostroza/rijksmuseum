package com.inkling.rijksmuseum.collectionfeature.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inkling.rijksmuseum.R;
import com.inkling.rijksmuseum.collectionfeature.repository.ArtObject;

import java.util.ArrayList;

class ArtCollectionAdapter extends RecyclerView.Adapter<ArtObjectViewHolder> {

    private ArrayList<ArtObject> artObjectList;

    public ArtCollectionAdapter( ArrayList<ArtObject> artObjectList) {
        this.artObjectList = artObjectList;
    }

    public void setData(ArrayList<ArtObject> artObject) {
        this.artObjectList = artObject;
    }

    @NonNull
    @Override
    public ArtObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.art_object_viewholder, parent, false);
        return new ArtObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtObjectViewHolder holder, int position) {
        ArtObject artObject = artObjectList.get(position);

        if(artObject != null){
            holder.setContent(artObject.getTitle(), artObject.getLongTitle());
        }
    }

    @Override
    public int getItemCount() {
        return artObjectList.size();
    }
}
