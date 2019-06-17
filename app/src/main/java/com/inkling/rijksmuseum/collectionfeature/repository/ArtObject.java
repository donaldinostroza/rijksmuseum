package com.inkling.rijksmuseum.collectionfeature.repository;

public class ArtObject {

    //private ArtLink artLink;
    private String id;
    private String objectNumber;
    private String title;
    private boolean hasImage;
    private String longTitle;


    public ArtObject(String id, String objectNumber, String title, boolean hasImage, String longTitle) {
        this.id = id;
        this.objectNumber = objectNumber;
        this.title = title;
        this.hasImage = hasImage;
        this.longTitle = longTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectNumber() {
        return objectNumber;
    }

    public void setObjectNumber(String objectNumber) {
        this.objectNumber = objectNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }
}
