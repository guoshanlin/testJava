package com.myclass.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsSearch {
	
	
	/**
	 * 链接数据库
	 * @return
	 */
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//"jdbc:mysql://localhost:3306/guoguo" 
            // "jdbc:mysql"为mysql链接；
			//  "localhost:3306";本地固定地址
			//  "guoguo";数据库名
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guoguo", "root", "root");
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		Connection connection =  getConnection();//链接数据库
		String sql = "SELECT * FROM `guoguoblog`";//查询数据库SQL语句；
		try {
			PreparedStatement statement = connection.prepareStatement(sql);//执行查询并返回查询结果
			ResultSet rs = statement.executeQuery();//查询结果转义
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("rowId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	/**
	 * 创建数据
	 * @return
	 */
	public List<Students> finStudents(){
		Connection connection =  getConnection();//链接数据库
		String sql = "SELECT * FROM `guoguoblog`";//查询数据库SQL语句；
		List<Students> student =new ArrayList<Students>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);//执行查询并返回查询结果
			ResultSet rs = statement.executeQuery();//查询结果转义
			while (rs.next()) {
				Students stu = new Students(rs.getString("name"),rs.getInt("age"));
				student.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
}
