package com.example.dorentermapp.UI.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dorentermapp.UI.Entity.Terms;

import java.util.List;

@Dao
public interface TermsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Terms thing);

    @Update
    void update (Terms thing);

    @Delete
    void delete (Terms thing);

    @Query("SELECT * FROM term_table ORDER BY termID ASC")
    List<Terms> getAllTerms();
}


