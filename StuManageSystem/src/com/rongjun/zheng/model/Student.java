package com.rongjun.zheng.model;

public class Student {
private int id;
private String studentnumber;
private String name;
private String birthday;
private String nativeplace;
private int classid;
private String studentremark;

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public Student(String studentnumber, String name, String birthday,
		String nativeplace, int classid, String studentremark) {
	super();
	this.studentnumber = studentnumber;
	this.name = name;
	this.birthday = birthday;
	this.nativeplace = nativeplace;
	this.classid = classid;
	this.studentremark = studentremark;
}
public Student(int id, String studentnumber, String name, String birthday,
		String nativeplace, int classid, String studentremark) {
	super();
	this.id = id;
	this.studentnumber = studentnumber;
	this.name = name;
	this.birthday = birthday;
	this.nativeplace = nativeplace;
	this.classid = classid;
	this.studentremark = studentremark;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getStudentnumber() {
	return studentnumber;
}

public void setStudentnumber(String studentnumber) {
	this.studentnumber = studentnumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBirthday() {
	return birthday;
}

public void setBirthday(String birthday) {
	this.birthday = birthday;
}

public String getNativeplace() {
	return nativeplace;
}

public void setNativeplace(String nativeplace) {
	this.nativeplace = nativeplace;
}

public int getClassid() {
	return classid;
}

public void setClassid(int classid) {
	this.classid = classid;
}

public String getStudentremark() {
	return studentremark;
}

public void setStudentremark(String studentremark) {
	this.studentremark = studentremark;
}

}
