package com.example.dorentermapp.UI.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.dorentermapp.UI.DAO.AssignmentsDao;
import com.example.dorentermapp.UI.DAO.CoursesDao;
import com.example.dorentermapp.UI.DAO.TermsDao;
import com.example.dorentermapp.UI.Entity.Assignments;
import com.example.dorentermapp.UI.Entity.Courses;
import com.example.dorentermapp.UI.Entity.Terms;

@Database(entities={Terms.class, Courses.class, Assignments.class}, version = 2,exportSchema = false)
public abstract class ThingDatabaseBuilder extends RoomDatabase {
    public abstract TermsDao termsDAO();
    public abstract CoursesDao coursesDAO();
    public abstract AssignmentsDao assignmentsDAO();

    private static volatile ThingDatabaseBuilder INSTANCE;

    static ThingDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ThingDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ThingDatabaseBuilder.class, "MyThingDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}
