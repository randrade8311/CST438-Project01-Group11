package com.example.cst438_project01_group11;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DreamTeamDao {
    @Insert
    void addTeam(DreamTeam dreamTeam);

//    @Query("SELECT COUNT(*) FROM dreamTeam")
}
