package com.example.cst438_project01_group11;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uId;

    @ColumnInfo(name = "name")
    private String uName;

    @ColumnInfo(name = "username")
    private String uUsername;

    @ColumnInfo(name = "password")
    private String uPassword;

    public User(String uName, String uUsername, String uPassword) {
        this.uName = uName;
        this.uUsername = uUsername;
        this.uPassword = uPassword;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int cId) {
        this.uId = cId;
    }

    public String getUUsername() {
        return uUsername;
    }

    public void setUUsername(String cUsername) {
        this.uUsername = cUsername;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String cPassword) {
        this.uPassword = cPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + uId +
                ", uName='" + uName + '\'' +
                ", uUsername='" + uUsername + '\'' +
                ", uPassword='" + uPassword + '\'' +
                '}';
    }
}