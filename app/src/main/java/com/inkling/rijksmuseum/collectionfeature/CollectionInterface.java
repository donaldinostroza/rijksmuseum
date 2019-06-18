package com.inkling.rijksmuseum.collectionfeature;

import com.inkling.rijksmuseum.collectionfeature.repository.ArtObject;

import java.util.ArrayList;

public interface CollectionInterface {

    interface View {
        void showCollection(ArrayList<ArtObject> artObject);
        void showError();
    }

    interface Presenter{
        void getCollection();
        void getCollectionByMaker(String maker);
    }

}
