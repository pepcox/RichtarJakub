package com.pepcox.richtar.richtarjakub.data;

public class Beer {

    private String title;
    private String imageUrl;
    private String subtitle;

    public Beer(final String title, final String imageUrl, final String subtitle) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
