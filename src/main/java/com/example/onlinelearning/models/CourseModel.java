package com.example.onlinelearning.models;

import jakarta.persistence.*;





@Entity
@Table(name = "course")
public class CourseModel {

    @Id
    @Column(name = "courseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "name", nullable = false, unique = true)
    private String courseName;

    @Column(name = "description")
    private String courseDescription;

    @Column(name = "difficulty")
    private String courseDifficulty;

    @Column(name = "detail")
    private String courseDetail;



    @Column(name = "url")
    private String courseUrl;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }


    public String getCourseUrl() {
        return courseUrl;
    }

    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }

    public String getCourseDifficulty() {
        return courseDifficulty;
    }

    public void setCourseDifficulty(String courseDifficulty) {
        this.courseDifficulty = courseDifficulty;
    }
}
