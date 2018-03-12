package com.rongjun.zheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rongjun.zheng.model.Student;
import com.rongjun.zheng.util.StringUtil;

public class StudentDao {
	public ResultSet studentList(Connection con,Student student)throws Exception{
		StringBuffer sql=new StringBuffer("select * from t_student");
		if(StringUtil.isNotEmpty(student.getName())){
			sql.append(" and name ='"+student.getName()+"'");
		}
		if(student.getClassid()!=0){
			sql.append(" and classid="+student.getClassid()+"");
		}
		PreparedStatement pstmt=con.prepareStatement(sql.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
		
	}
	public int StudentModify(Connection con,Student student)throws Exception{
		StringBuffer sql1=new StringBuffer("select * from t_student where");
		sql1.append(" id="+student.getId());
		sql1.append(" and studentnumber='"+student.getStudentnumber()+"'");
		sql1.append(" and name='"+student.getName()+"'");
		sql1.append(" and birthday='"+student.getBirthday()+"'");
		sql1.append(" and nativeplace='"+student.getNativeplace()+"'");
		sql1.append(" and classid="+student.getClassid());
		sql1.append(" and studentremark='"+student.getStudentremark()+"'");
		PreparedStatement pstmt1=con.prepareStatement(sql1.toString());
		ResultSet rs=pstmt1.executeQuery();
		if(rs.next()){
			return 2;
		}
		String sql2="select * from t_student where name=? and classid=?";
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		pstmt2.setString(1, student.getName());
		pstmt2.setInt(2, student.getClassid());
		ResultSet rs1=pstmt2.executeQuery();
		if(rs1.next()){
			String sql="update t_student set studentnumber=?,birthday=?," +
					"nativeplace=?,studentremark=? where name=? and classid=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
		     pstmt.setString(1, student.getStudentnumber());
		     pstmt.setString(2, student.getBirthday());
		     pstmt.setString(3, student.getNativeplace());
		     pstmt.setString(4,student.getStudentremark());
		     pstmt.setString(5, student.getName());
		     pstmt.setInt(6, student.getClassid());
		     return pstmt.executeUpdate();
		}
		String sql="update t_student set studentnumber=?,birthday=?," +
					"nativeplace=?,studentremark=?,name=?,classid=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStudentnumber());
		pstmt.setString(2, student.getBirthday());
		pstmt.setString(3, student.getNativeplace());
		pstmt.setString(4, student.getStudentremark());
		pstmt.setString(5, student.getName());
		pstmt.setInt(6, student.getClassid());
		pstmt.setInt(7, student.getId());
		return pstmt.executeUpdate();
		
		
	}
	public int studentDelete(Connection con,String id)throws Exception{
		String sql="delete from t_student where id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
			
	}
	public boolean getstudentbyclassID(Connection con,int classID)throws Exception{
		String sql1="SELECT * FROM t_student  WHERE classid=?";
	 	PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setInt(1,classID);
		ResultSet rs=pstmt1.executeQuery();
		return rs.next();
	}
	
	
	
	
	
	
	
	
public int studentAdd(Connection con,Student student)throws Exception{
	String sql1="SELECT * FROM t_student  WHERE name=? AND classid=?";
 	PreparedStatement pstmt1=con.prepareStatement(sql1);
	pstmt1.setString(1,student.getName());
	pstmt1.setInt(2,student.getClassid());
	ResultSet rs=pstmt1.executeQuery();
	if(rs.next()){
		return 2;
	}
	String sql="insert into t_student values(null,?,?,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1,student.getStudentnumber());
	pstmt.setString(2,student.getName());
	pstmt.setString(3, student.getBirthday());
	pstmt.setString(4, student.getNativeplace());
	pstmt.setInt(5, student.getClassid());
	pstmt.setString(6, student.getStudentremark());	
	return pstmt.executeUpdate();
}
}
