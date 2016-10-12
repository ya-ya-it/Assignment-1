package assignment;

import java.util.Collection;

public class GUI_Course_Davydenko_200335788{

    private String courseName;
    private String courseCode;
    private String instructor;
    private Integer grade;
    private String letterGrade;

    public GUI_Course_Davydenko_200335788() {
        this.courseName = "";
        this.courseCode = "";
        this.instructor = "";
        this.grade = 0;
        this.letterGrade = "";
    }

    public GUI_Course_Davydenko_200335788(String courseName, String courseCode, 
            String instructor, Integer grade) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.grade = grade;
        this.letterGrade = GUI_Code_Davydenko_200335788.getLetterGrades(grade);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

}
