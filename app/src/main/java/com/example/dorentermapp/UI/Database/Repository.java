package com.example.dorentermapp.UI.Database;

import android.app.Application;

import com.example.dorentermapp.UI.DAO.AssignmentsDao;
import com.example.dorentermapp.UI.DAO.CoursesDao;
import com.example.dorentermapp.UI.DAO.TermsDao;
import com.example.dorentermapp.UI.Entity.Assignments;
import com.example.dorentermapp.UI.Entity.Courses;
import com.example.dorentermapp.UI.Entity.Terms;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private TermsDao mTermDao;
    private CoursesDao mCourseDao;
    private AssignmentsDao mAssignmentDao;
    private List<Terms>mAllTerms;
    private List<Courses>mAllCourses;
    private List<Assignments>mAllAssignments;

    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecuter= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

//need deletes*****
    public Repository(Application application){
        ThingDatabaseBuilder db = ThingDatabaseBuilder.getDatabase(application);
        mTermDao = db.termsDAO();
        mCourseDao = db.coursesDAO();
        mAssignmentDao = db.assignmentsDAO();
    }

    public List<Terms> getmAllThings(){
        databaseExecuter.execute(()->{
            mAllTerms = mTermDao.getAllTerms();
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return  mAllTerms;
    }

    //do for updates and deletes too
    public void insert(Terms thing){
        databaseExecuter.execute(()->{
            mTermDao.insert(thing);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Terms thing){
        databaseExecuter.execute(()->{
            mTermDao.update(thing);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    public List<Courses> getmAllCourses(){
        databaseExecuter.execute(()->{
            mAllCourses = mCourseDao.getAllCourses();
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return  mAllCourses;
    }

    //do for updates and deletes too
    public void insert(Courses course){
        databaseExecuter.execute(()->{
            mCourseDao.insert(course);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Courses course){
        databaseExecuter.execute(()->{
            mCourseDao.update(course);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    public List<Assignments> getmAllAssignments(){
        databaseExecuter.execute(()->{
            mAllAssignments = mAssignmentDao.getAllAssignments();
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return  mAllAssignments;
    }

    //do for updates and deletes too
    public void insert(Assignments assignment){
        databaseExecuter.execute(()->{
            mAssignmentDao.insert(assignment);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Assignments assignment){
        databaseExecuter.execute(()->{
            mAssignmentDao.update(assignment);
        });
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
