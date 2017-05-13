package com.src.starters.Model;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.src.starters.Entities.Student;
import com.src.starters.Entities.Teacher;

public class TeacherModel {
	
	
	public String AddTeacher(String password , String name ,String gender , String mail , int age ) throws SQLException
	{
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		conn.statement= (PreparedStatement) conn.connection.prepareStatement("insert into student (password,name,gender,mail,age) VALUES (?, ?, ?,?, ?)");
		conn.statement.setString(1, password);
		conn.statement.setString(2,name);
		conn.statement.setString(3,gender);
		conn.statement.setString(4,mail);
		conn.statement.setLong(5,age);	
		conn.statement.executeUpdate();
		conn.statement.close();
		conn.connection.close();
		
		return "Added";
		
	}
	
   public Teacher GetTeacher(String password , String mail) throws SQLException
	{
		Teacher x =new Teacher();
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		
		String sql="SELECT * FROM teacher where password=? and mail=?" ;
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setString(1, password);
		conn.statement.setString(2, mail);
		ResultSet result=conn.statement.executeQuery();

		if(result.next())
		{
			x.setPassword(result.getString("password"));
			x.setMail(result.getString("mail"));
			x.setAge(result.getInt("age"));
			x.setGender(result.getString("gender"));
			x.setName(result.getString("name"));
			x.setScore(result.getInt("score"));
			x.setimage(result.getBlob("profileoicture"));
			
		}
		conn.statement.close();
		conn.connection.close();
		return x;
	
	
				
	}
	
	public void UpdateScore(int score,String password) throws SQLException
	{
		DBConnection conn =new DBConnection();
        conn.Connectiontomysql();
		
		String sql ="update teacher set score=? where password=?";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setInt(1, score);
		conn.statement.setString(2, password);
		conn.statement.executeUpdate();
		conn.statement.close();
		conn.connection.close();
	}
	
	
	public void UpdateProfilePicture(Image x , String password ) //// to be continue //////
	{
		
	}

}
