package com.src.starters.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.src.starters.Entities.Discription;
import com.src.starters.Entities.Game;
import com.src.starters.Entities.MCQ_Game;
import com.src.starters.Entities.Programming_Game;
import com.src.starters.Entities.T_F;

public class GameModel 
{
	public Game load_game(String gamecategory ,String gamename ) throws SQLException  ////// to continue 
	{
		
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		String query="SELECT * FROM games Where gamename=? and availability=?";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(query);
		conn.statement.setString(1,gamename);
		conn.statement.setInt(2, 1);
		ResultSet result=conn.statement.executeQuery();
		
		if(gamecategory.equals("MCQ"))
		{
			System.out.println("done MCQ ");
			MCQ_Game x = new MCQ_Game();
			
			if(result.next())
			{
				  //////////// get question from mcq_questions table /////
			    
				
			}
			conn.statement.close();
			conn.connection.close();
			return x;
			
		}
		else if(gamecategory.equals("T_F"))
		{
			System.out.println("done T_F ");
			T_F x = new T_F();
			
			if(result.next())
			{
			     ///////// get questions from T and false table ////
				
			}
			conn.statement.close();
			conn.connection.close();
			return x;
		}
		else 
		{
			System.out.println("done Programmin Game ");
			Programming_Game x = new Programming_Game();
		
			if(result.next())
			{
			    /////////// get questions from programming table ////////////////////
				
			}
			conn.statement.close();
			conn.connection.close();
			return x;
		}
		
	}
	
	public void Load_course_games(ArrayList<Discription> x  , String cname) throws SQLException
	{
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		String query="SELECT gamename and category FROM games where cname=? and availability=?";
		
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(query);
		conn.statement.setString(1, cname);
		conn.statement.setInt(2, 1);
		
        ResultSet result=conn.statement.executeQuery();
		
		while(result.next())
		{
			 Discription d =new  Discription();
			 d.name=result.getString("gamename");
			 d.category=result.getString("category");
			 x.add(d);
		}
		
	}
	
	public void Add_game(String cname , String category ) // to be implemented 
	{
		
		
		
	}
	
	public boolean add_comment_on_game(String Student_mail , String game_name , String comment ) throws SQLException
	{
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		conn.statement=(PreparedStatement)conn.connection.prepareStatement("insert into game_comments(game_name,user_mail,comment) VALUES (?, ?, ?)");
		conn.statement.setString(1, game_name);
		conn.statement.setString(2, Student_mail);
		conn.statement.setString(3, comment);
		conn.statement.executeUpdate();
		
		String sql="SELECT mail_of_teacher1 and mail_of_teacher2 FROM games where gamename=? " ;
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setString(1, game_name);
		ResultSet result=conn.statement.executeQuery();
		String t1 , t2 ;
		if(result.next())
		{
			t1=result.getString("mail_of_teacher1");
			t2=result.getString("mail_of_teacher2");
			sql="insert into notifications (t_mail,notification) VALUES (?, ?)";
			conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
			conn.statement.setString(1, t1);
			String n="New Comment has been added on "+game_name+"game";
			conn.statement.setString(2,n);
			conn.statement.executeUpdate();
			
			if(t2!="NULL")
			{
				sql="insert into notifications (t_mail,notification) VALUES (?, ?)";
				conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
				conn.statement.setString(1, t2);
				String n2="New Comment has been added on "+game_name+"game";
				conn.statement.setString(2,n2);
				conn.statement.executeUpdate();
			}
			
		}
		
		conn.statement.close();
		conn.connection.close();
		return true;
	}
	
	public String Set_availability( String t_mail , int value , String game_name ) throws SQLException
	{
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		
		String sql="SELECT mail_of_teacher1 and mail_of_teacher2 FROM games where gamename=? " ;
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setString(1, game_name);
		ResultSet result=conn.statement.executeQuery();
		
		if(result.next())
		{
			if(t_mail.equals(result.getString("mail_of_teacher1"))  || t_mail.equals(result.getString("mail_of_teacher2" ))  )
			{
				 sql ="update games set availability=? where gamename=?";
				 conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
				 conn.statement.setInt(1, value);
				 conn.statement.setString(2, game_name);
				 conn.statement.executeUpdate();
				 conn.statement.close();
				 conn.connection.close();
				 return "Done";
			}
		}
		return "Can't be updated";
		
	}

}