package com.dodgetime.sets;

import java.util.ArrayList;

import com.dodgetime.main.GameObject;

public class Set extends Object {
	
	private static ArrayList<GameObject> enemyList = new ArrayList<GameObject>();
	
	public Set()
	{
		
	}
	
	public void addEnemy(GameObject object)
	{
		enemyList.add(object);
	}
	
	public ArrayList<GameObject> getEnemyList()
	{
		return enemyList;
	}
	
	
	

}
