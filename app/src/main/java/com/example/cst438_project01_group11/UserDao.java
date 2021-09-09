package com.example.cst438_project01_group11;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void addUser(User user);

    @Query("SELECT COUNT(*) FROM users")
    int count();

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Delete
    void delete(User user);
}
