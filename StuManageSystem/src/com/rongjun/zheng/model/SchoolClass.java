package com.rongjun.zheng.model;

public class SchoolClass {
	private int id;
	private String className;
	private int gradeID;
	private String classRemark;
	private String gradeName;
	public SchoolClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchoolClass(String className, String gradeName) {
		super();
		this.className = className;
		this.gradeName = gradeName;
	}

	public SchoolClass(String className, int gradeID, String classRemark) {
		super();
		this.className = className;
		this.gradeID = gradeID;
		this.classRemark = classRemark;
	}
	
	public SchoolClass(int id, String className, int gradeID, String classRemark) {
		super();
		this.id = id;
		this.className = className;
		this.gradeID = gradeID;
		this.classRemark = classRemark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getGradeID() {
		return gradeID;
	}
	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}
	public String getClassRemark() {
		return classRemark;
	}
	public void setClassRemark(String classRemark) {
		this.classRemark = classRemark;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String toString(){
		return this.getGradeName()+this.getClassName();
	}
	

}
