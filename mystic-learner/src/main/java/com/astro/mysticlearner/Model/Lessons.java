package com.astro.mysticlearner.Model;

import javax.persistence.JoinColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lessons")
public class Lessons {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer id;

	 @Column(nullable=false)
	 private String moduleName;
	 @Column
	 private String lectureName;
	 @Column
	 private String lectureLink;
	 @Column
	 private String description;
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "course_id", referencedColumnName = "id")
	 private Courses course;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureLink() {
		return lectureLink;
	}

	public void setLectureLink(String lectureLink) {
		this.lectureLink = lectureLink;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 
	 
}
