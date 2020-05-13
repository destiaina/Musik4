package com.example.musik.api.models;

public class Song {
    private int id, artist_id;
    private String name, releasedate, artist_name, image, zip, shorturl, shareurl;

    public Song(int id, int artist_id, String name, String releasedate, String artist_name, String image, String zip, String shorturl, String shareurl) {
        this.id = id;
        this.artist_id = artist_id;
        this.name = name;
        this.releasedate = releasedate;
        this.artist_name = artist_name;
        this.image = image;
        this.zip = zip;
        this.shorturl = shorturl;
        this.shareurl = shareurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getShorturl() {
        return shorturl;
    }

    public void setShorturl(String shorturl) {
        this.shorturl = shorturl;
    }

    public String getShareurl() {
        return shareurl;
    }

    public void setShareurl(String shareurl) {
        this.shareurl = shareurl;
    }
}

