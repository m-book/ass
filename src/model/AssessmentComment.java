package model;

import java.util.ArrayList;
import java.util.Date;

public class AssessmentComment {
	private int id;
	private Date date;
	private int year;
	private String content;
	private Student student;
	private Lesson lesson;
	
	public void register(String content, Student student){
		hogehoge
	}
	public static ArrayList<AssessmentComment> getList(int claasId){
		return null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
}
