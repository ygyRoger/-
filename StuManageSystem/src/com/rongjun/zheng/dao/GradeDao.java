package com.rongjun.zheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rongjun.zheng.model.Grade;
import com.rongjun.zheng.util.StringUtil;

public class GradeDao {
	public int gradeAdd(Connection con,Grade grade)throws Exception{
		String sql="select * from t_grade where gradeName=?";
		PreparedStatement pstmt1=con.prepareStatement(sql);
		pstmt1.setString(1, grade.getGradeName());
		ResultSet rs=pstmt1.executeQuery();
		if(rs.next()){
			return 2;
		}
		String sql1="insert into t_grade values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);
		pstmt.setString(1, grade.getGradeName());
		pstmt.setString(2, grade.getGradeRemark());
		return pstmt.executeUpdate();
		
	}
	public ResultSet gradeList(Connection con,Grade grade)throws Exception{
		StringBuffer sql=new StringBuffer("select * from t_grade");
		if(grade.getGradeName()!=null){
		sql.append(" and gradeName like '%"+grade.getGradeName()+"%'");
	}
		PreparedStatement pstmt=con.prepareStatement(sql.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public int gradeDelete(Connection con,String id)throws Exception{
		String sql="delete from t_grade where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	public int gradeModify(Connection con,Grade grade,String id)throws Exception{
		String sql1="select * from t_grade where gradeName=? and gradeRemark=?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, grade.getGradeName());
		pstmt1.setString(2, grade.getGradeRemark());
		ResultSet rs=pstmt1.executeQuery();
		if(rs.next()){
			return 2;
		}
		String sql2="select * from t_grade where gradeName=?";
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		pstmt2.setString(1, grade.getGradeName());
		ResultSet rs1=pstmt2.executeQuery();
		if(rs1.next()){
			String sql="update t_grade set gradeRemark=? where gradeName=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
		     pstmt.setString(2, grade.getGradeName());
		     pstmt.setString(1, grade.getGradeRemark());
		     return pstmt.executeUpdate();
		}			
		String sql="update t_grade set gradeName=?,gradeRemark=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
	     pstmt.setString(1, grade.getGradeName());
	     pstmt.setString(2, grade.getGradeRemark());
	     pstmt.setString(3, id);
	     return pstmt.executeUpdate();
	}
}
