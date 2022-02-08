package com.example.dorentermapp.UI.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dorentermapp.UI.Entity.Assignments;
import com.example.dorentermapp.UI.Entity.Courses;

import java.util.List;

@Dao
public interface AssignmentsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Assignments assignment);

    @Update
    void update (Assignments assignment);

    @Delete
    void delete (Assignments assignment);

    @Query("SELECT * FROM assignment_table ORDER BY assignmentID ASC")
    List<Assignments> getAllAssignments();
}
