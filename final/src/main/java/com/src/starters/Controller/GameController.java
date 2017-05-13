package com.src.starters.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.starters.Entities.Discription;
import com.src.starters.Entities.Game;
import com.src.starters.Entities.MCQ_Game;
import com.src.starters.Entities.Programming_Game;
import com.src.starters.Entities.T_F;
import com.src.starters.Model.GameModel;


@RestController
public class GameController
{
	@RequestMapping("/play/{gamecategory}/{name}")
	public Game Play_Game(@PathVariable String gamecategory ,@PathVariable String name ) throws SQLException
	{
		
		GameModel m=new GameModel();
		if(gamecategory.equals("MCQ"))
		{
			MCQ_Game x=new MCQ_Game();
			 x =(MCQ_Game) m.load_game(gamecategory, name);
			 return x;
		}
		else if(gamecategory.equals("T_F"))
		{
			T_F x = new T_F();
			x=(T_F) m.load_game(gamecategory, name);
			return x;
		}
		else
		{
			Programming_Game x = new Programming_Game();
			x=(Programming_Game) m.load_game(gamecategory, name);
			return x;
		}
		
	}
	
	
	@RequestMapping("/showcoursegames/{coursename}")
	public ArrayList<Discription> Show_Games_of_specific_course(@PathVariable String coursename) throws SQLException 
	{
		ArrayList<Discription> g_dis=new ArrayList<Discription>();
		GameModel m=new GameModel();
		m.Load_course_games(g_dis,coursename);
		
		return g_dis;
	}
	
	
	@RequestMapping("/Teacher/creategame/") // to be implemented ///////// 
	public void Create_Game()
	{
		
		
		
	}
	
	@RequestMapping("/comment_on_game/Student/{Student_mail}/{game_name}/{comment}")
	public String Comment_Game(@PathVariable String Student_mail , @PathVariable String game_name , @PathVariable String comment) throws SQLException
	{
		GameModel m =new GameModel();
		boolean result=m.add_comment_on_game(Student_mail, game_name, comment);
		if(result==true)
			return "Done";
		else
			return "Error";
	}
	
	@RequestMapping("/updateavailablity/{gamename}/{teacher_mail}/{value}")
	public String Cancel_game(@PathVariable String gamename , @PathVariable String teacher_mail , @PathVariable int value) throws SQLException
	{ 
		GameModel m =new GameModel();
		return m.Set_availability(teacher_mail, value, gamename);
	}
	
}
