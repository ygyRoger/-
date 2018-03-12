package com.rongjun.zheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rongjun.zheng.model.Manager;

public class ManagerDao {
	
	public Manager login(Connection con,String user,String password)throws Exception{
		String sql="select * from manage_table where user=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
		Manager currentManager=null;
		if(rs.next()){
			currentManager=new Manager();
			currentManager.setUser(rs.getString("user"));
			currentManager.setPassword(rs.getString("password"));
			currentManager.setEmail(rs.getString("Email"));
		}
		return currentManager ;
	}
	public int register(Connection con,Manager manager)throws Exception{
		String sql="select * from manage_table where user=?";
		PreparedStatement pstmt1=con.prepareStatement(sql);
		pstmt1.setString(1, manager.getUser());
		ResultSet rs=pstmt1.executeQuery();
		if(rs.next()){
			return 2;
		}
		else{
		String sql1="insert into manage_table values(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);
		pstmt.setString(1, manager.getUser());
		pstmt.setString(2, manager.getPassword());
		pstmt.setString(3, manager.getEmail());
		return pstmt.executeUpdate();
		}
	}

}
