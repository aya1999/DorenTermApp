package com.example.dorentermapp.UI.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="assignment_table")
public class Assignments {
    private int courseID;
    @PrimaryKey(autoGenerate = true)
    private int assignmentID;
    private String assignmentName;
    private String assignmentDate;
    private String assignmentType;




    public Assignments(int assignmentID, String assignmentName, String assignmentDate, String assignmentType, int courseID) {
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
        this.assignmentDate = assignmentDate;
        this.assignmentType = assignmentType;
        this.courseID = courseID;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Assignments{" +
                "assessmentID=" + assignmentID +
                ", assessmentName='" + assignmentName + '\'' +
                ", assessmentDate='" + assignmentDate + '\'' +
                ", assessmentType='" + assignmentType + '\'' +
                ", courseID=" + courseID +
                '}';
    }
}
