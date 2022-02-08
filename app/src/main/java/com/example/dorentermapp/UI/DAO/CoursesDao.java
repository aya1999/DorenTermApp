package com.example.dorentermapp.UI.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dorentermapp.UI.Entity.Courses;


import java.util.List;

@Dao
public interface CoursesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Courses course);

    @Update
    void update (Courses course);

    @Delete
    void delete (Courses course);

    @Query("SELECT * FROM course_table ORDER BY courseID ASC")
    List<Courses> getAllCourses();


}
