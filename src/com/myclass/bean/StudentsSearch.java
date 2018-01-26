package com.myclass.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toolclass.bean.PublicConstant;

public class StudentsSearch {

	/**
	 * 链接数据库
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(PublicConstant.driver);
			Connection connection = DriverManager.getConnection(
					PublicConstant.url, PublicConstant.pathName,
					PublicConstant.password);
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		Connection connection = getConnection();// 链接数据库
		try {
			PreparedStatement statement = connection
					.prepareStatement(PublicConstant.sqlguoguoblog);// 执行查询并返回查询结果
			ResultSet rs = statement.executeQuery();// 查询结果转义
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
	 * 
	 * @return
	 */
	public List<Students> finStudents(String sql, int age, String keyWorld) {
		Connection connection = getConnection();// 链接数据库
		// String sql = "SELECT * FROM `guoguoblog`";//查询数据库SQL语句；
		List<Students> student = new ArrayList<Students>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);// 执行查询并返回查询结果
			statement.setObject(1, age);
			statement.setObject(2, "%" + keyWorld + "%");
			ResultSet rs = statement.executeQuery();// 查询结果转义
			while (rs.next()) {
				Students stu = new Students(rs.getString("name"),
						rs.getInt("age"));
				student.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
}
