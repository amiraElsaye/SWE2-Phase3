package com.src.starters.Entities;

public class Game {
	 String gameName ;
	 String category ;
	 String courseName ;
	 int time ;
	
	 
	 
	public void setName(String name){
		this.gameName=name;
	}
	
	public String getName(){
		return gameName;
	}
	
	public void setCategory(String category){
		this.category=category;
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setTime(int Time){
		this.time=Time;
	}
	
	public int getTime(){
		return time;
	}

	public void setCoursename(String coursename)
	{
		this.courseName=coursename ;
	}
	
    public String getCoursename()
	{
		return courseName ;
	}
	
	

}
