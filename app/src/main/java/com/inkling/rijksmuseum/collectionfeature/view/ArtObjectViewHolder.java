package com.inkling.rijksmuseum.collectionfeature.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inkling.rijksmuseum.R;

class ArtObjectViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTV;
    private TextView descriptionTV;


    public ArtObjectViewHolder(@NonNull View itemView) {
        super(itemView);

        titleTV = itemView.findViewById(R.id.art_title);
        descriptionTV = itemView.findViewById(R.id.art_desc);

    }

    public void setContent(String title, String desc){
        titleTV.setText(title);
        descriptionTV.setText(desc);

    }

}
