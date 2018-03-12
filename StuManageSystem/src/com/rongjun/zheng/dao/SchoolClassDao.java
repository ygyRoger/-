package com.rongjun.zheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rongjun.zheng.model.SchoolClass;
import com.rongjun.zheng.util.StringUtil;

public class SchoolClassDao {
	public ResultSet classList(Connection con,SchoolClass schoolClass) throws Exception{
		StringBuffer sql=new StringBuffer("SELECT * FROM t_class tc,t_grade tg WHERE tc.gradeID=tg.id");
		if(StringUtil.isNotEmpty(schoolClass.getClassName())){
			sql.append(" and tc.className='"+schoolClass.getClassName()+"'");
		}
        if(StringUtil.isNotEmpty(schoolClass.getGradeName())){
            sql.append(" and tg.gradeName='"+schoolClass.getGradeName()+"'");
		}
		PreparedStatement pstmt =con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
		
	}
	public int classDelete(Connection con,String id) throws Exception{
		String sql="delete from t_class where id=?";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
	}
	public int classAdd(Connection con,SchoolClass schoolClass)throws Exception{
		String sql1="SELECT * FROM t_class  WHERE className=? AND gradeID=?";
     	PreparedStatement pstmt1=con.prepareStatement(sql1);
    	pstmt1.setString(1,schoolClass.getClassName());
		pstmt1.setInt(2,schoolClass.getGradeID());
		ResultSet rs=pstmt1.executeQuery();
		if(rs.next()){
			return 2;
		}
		String sql="insert into t_class values(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,schoolClass.getClassName());
		pstmt.setInt(2,schoolClass.getGradeID());
		pstmt.setString(3, schoolClass.getClassRemark());
		return pstmt.executeUpdate();
	}

	public boolean getclassByGradeID(Connection con,String id)throws Exception{
		String sql="select *from t_class where gradeID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	public int classModify(Connection con,SchoolClass schoolClass)throws Exception{
		String sql1="select * from t_class where className=? and gradeID=? and classRemark=?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, schoolClass.getClassName());
		pstmt1.setInt(2, schoolClass.getGradeID());
		pstmt1.setString(3, schoolClass.getClassRemark());
		ResultSet rs=pstmt1.executeQuery();
		if(rs.next()){
			return 2;
		}
		String sql2="select * from t_class where className=? and gradeID=?";
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		pstmt2.setString(1, schoolClass.getClassName());
		pstmt2.setInt(2, schoolClass.getGradeID());
		ResultSet rs1=pstmt2.executeQuery();
		if(rs1.next()){
			String sql="update t_class set classRemark=? where className=? and gradeID=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
		     pstmt.setString(1, schoolClass.getClassRemark());
		     pstmt.setString(2, schoolClass.getClassName());
		     pstmt.setInt(3, schoolClass.getGradeID());
		     return pstmt.executeUpdate();
		}
		String sql="update t_class set className=?,gradeID=?,classRemark=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, schoolClass.getClassName());
		pstmt.setInt(2, schoolClass.getGradeID());
		pstmt.setString(3, schoolClass.getClassRemark());
		pstmt.setInt(4, schoolClass.getId());
		return pstmt.executeUpdate();
		
	}
	
}
