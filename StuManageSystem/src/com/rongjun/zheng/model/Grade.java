package com.rongjun.zheng.model;

public class Grade {
	private int id;
	private String gradeName;
	private String gradeRemark;
	public Grade(String gradeName, String gradeRemark) {
		super();
		this.gradeName = gradeName;
		this.gradeRemark = gradeRemark;
	}
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getGradeRemark() {
		return gradeRemark;
	}
	public void setGradeRemark(String gradeRemark) {
		this.gradeRemark = gradeRemark;
	}
	@Override
	public String toString(){
		return this.getGradeName();
	}

}
