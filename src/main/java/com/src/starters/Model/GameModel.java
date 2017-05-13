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
		String query="";
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		if(gamecategory.equals("MCQ"))
		{
			System.out.println("done MCQ ");
			MCQ_Game x = new MCQ_Game();
			query="SELECT * FROM mcq_games Where gamename=?";
			
			conn.statement= (PreparedStatement) conn.connection.prepareStatement(query);
			conn.statement.setString(1,gamename);
			ResultSet result=conn.statement.executeQuery();
			if(result.next())
			{
				
			    
				
			}
			conn.statement.close();
			conn.connection.close();
			return x;
			
		}
		else if(gamecategory.equals("T_F"))
		{
			System.out.println("done T_F ");
			T_F x = new T_F();
			query="SELECT * FROM t_and_f where gamename=?";
			
			conn.statement= (PreparedStatement) conn.connection.prepareStatement(query);
			conn.statement.setString(1, gamename);
			ResultSet result=conn.statement.executeQuery();
			if(result.next())
			{
			
				
			}
			conn.statement.close();
			conn.connection.close();
			return x;
		}
		else 
		{
			System.out.println("done Programmin Game ");
			Programming_Game x = new Programming_Game();
			query="SELECT * FROM programming_games where g_name=?";
		
			conn.statement= (PreparedStatement) conn.connection.prepareStatement(query);
			conn.statement.setString(1, gamename);
			ResultSet result=conn.statement.executeQuery();
			if(result.next())
			{
			
				
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
		String query="SELECT gamename FROM mcq_games where cname=?";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(query);
		conn.statement.setString(1, cname);
        ResultSet result=conn.statement.executeQuery();
		
       
		while(result.next())
		{
			 Discription d =new  Discription();
			 d.name=result.getString("gamename");
			 d.category="MCQ";
			 x.add(d);
		}
		
		 query="SELECT g_name FROM programming_games where c_name=?";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(query);
		conn.statement.setString(1, cname);
        result=conn.statement.executeQuery();
		
       
		while(result.next())
		{
			 Discription d =new  Discription();
			 d.name=result.getString("g_name");
			 d.category="Programming_Game";
			 x.add(d);
		}
		
		query="SELECT gamename FROM t_and_f where coursename=?";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(query);
		conn.statement.setString(1, cname);
        result=conn.statement.executeQuery();
		
       
		while(result.next())
		{
			 Discription d =new  Discription();
			 d.name=result.getString("gamename");
			 d.category="T_F";
			 x.add(d);
		}
		
		
	}
	
	
	public void Add_game(String cname ) // to be implemented 
	{
		
		
		
	}

}