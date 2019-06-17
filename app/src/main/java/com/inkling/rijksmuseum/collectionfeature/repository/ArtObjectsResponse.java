package com.inkling.rijksmuseum.collectionfeature.repository;

import java.util.ArrayList;

public class ArtObjectsResponse {

    private int elapsedMilliseconds;
    private int count;
    //private int countFacets;
    private ArrayList<ArtObject> artObjects;


    public ArtObjectsResponse(int elapsedMilliseconds, int count, ArrayList<ArtObject> artObjects) {
        this.elapsedMilliseconds = elapsedMilliseconds;
        this.count = count;
        this.artObjects = artObjects;
    }


    public int getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    public void setElapsedMilliseconds(int elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<ArtObject> getArtObjects() {
        return artObjects;
    }

    public void setArtObjects(ArrayList<ArtObject> artObjects) {
        this.artObjects = artObjects;
    }
}
