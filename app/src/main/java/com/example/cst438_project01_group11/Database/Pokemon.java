package com.example.cst438_project01_group11.Database;

public class Pokemon {

    private int mId;
    private int mImage;
    private String mName;

    public Pokemon(int id, int image, String name) {
        mId = id;
        mImage = image;
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public int getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }
}
