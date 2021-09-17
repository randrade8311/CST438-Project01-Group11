package com.example.cst438_project01_group11.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cst438_project01_group11.DreamTeam;

import java.util.List;

@Dao
public interface DreamTeamDao {
    @Insert
    void addTeam(DreamTeam dreamTeam);

    @Query("SELECT COUNT(*) FROM dreamTeam")
    int count();

    @Query("SELECT * FROM dreamTeam")
    List<DreamTeam> getAll();

    //    @Query("SELECT pokemon1,pokemon2,pokemon3,pokemon4,pokemon5,pokemon6 FROM dreamTeam where uId is :uId")
    @Query("SELECT * FROM dreamTeam where uId is :uId")
    List<DreamTeam> getAllPokemon(int uId);

    @Query("UPDATE dreamTeam SET pokemon1 = :pokemon1 WHERE uId = :uId")
    int updatePoke1(String pokemon1, int uId);

    @Query("UPDATE dreamTeam SET pokemon2 = :pokemon2 WHERE uId = :uId")
    int updatePoke2(String pokemon2, int uId);

    @Query("UPDATE dreamTeam SET pokemon3 = :pokemon3 WHERE uId = :uId")
    int updatePoke3(String pokemon3, int uId);

    @Query("UPDATE dreamTeam SET pokemon4 = :pokemon4 WHERE uId = :uId")
    int updatePoke4(String pokemon4, int uId);

    @Query("UPDATE dreamTeam SET pokemon5 = :pokemon5 WHERE uId = :uId")
    int updatePoke5(String pokemon5, int uId);

    @Query("UPDATE dreamTeam SET pokemon6 = :pokemon6 WHERE uId = :uId")
    int updatePoke6(String pokemon6, int uId);

    @Query("SELECT * FROM dreamTeam where username = :username")
    DreamTeam getDreamTeamByUsername(String username);
}
