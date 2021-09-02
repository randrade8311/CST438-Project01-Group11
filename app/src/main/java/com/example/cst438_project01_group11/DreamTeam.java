package com.example.cst438_project01_group11;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dreamTeam")
public class DreamTeam {
    @PrimaryKey(autoGenerate = true)
    private int dtId;

    @ColumnInfo(name = "username")
    private String uUsername;

    @ColumnInfo(name = "uId")
    private int uId;

    @ColumnInfo(name = "pokemon1")
    private String pokemon1;

    @ColumnInfo(name = "pokemon2")
    private String pokemon2;

    @ColumnInfo(name = "pokemon3")
    private String pokemon3;

    @ColumnInfo(name = "pokemon4")
    private String pokemon4;

    @ColumnInfo(name = "pokemon5")
    private String pokemon5;

    @ColumnInfo(name = "pokemon6")
    private String pokemon6;

    public int getDtId() { return dtId;};

    public void setDtId(int dtId) {
        this.dtId = dtId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(String pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public String getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(String pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public String getPokemon3() {
        return pokemon3;
    }

    public void setPokemon3(String pokemon3) {
        this.pokemon3 = pokemon3;
    }

    public String getPokemon4() {
        return pokemon4;
    }

    public void setPokemon4(String pokemon4) {
        this.pokemon4 = pokemon4;
    }

    public String getPokemon5() {
        return pokemon5;
    }

    public void setPokemon5(String pokemon5) {
        this.pokemon5 = pokemon5;
    }

    public String getPokemon6() {
        return pokemon6;
    }

    public void setPokemon6(String pokemon6) {
        this.pokemon6 = pokemon6;
    }
}
