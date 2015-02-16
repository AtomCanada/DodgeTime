package com.dodgetime.sets;

import java.util.Random;

import com.dodgetime.enemies.Attacker;
import com.dodgetime.enemies.Floater;
import com.dodgetime.enemies.MonsterFloater;
import com.dodgetime.enemies.Shooter;
import com.dodgetime.main.Game;
import com.dodgetime.main.Handler;
import com.dodgetime.main.ObjectType;

public class RandomSet extends Set {
	
	public RandomSetID id;
	
	private Handler handler;
	
	public enum RandomSetID
	{
		DTRS_0,
		DTRS_1,
		DTRS_2,
		DTRS_3,
		DTRS_4,
		DTRS_5,
		DTRS_6,
		DTRS_7,
		DTRS_8,
		DTRS_9,
		DTRS_10,
		DTRS_11,
		DTRS_12,
		DTRS_13,
		DTRS_14,
		DTRS_15,
	}
	
	public RandomSet()
	{
		int i = new Random().nextInt(16);
		this.id = RandomSetID.valueOf("DTRS_" + i);
		
		initializeSet();
	}
	
	public RandomSetID getSetID()
	{
		return this.id;
	}
	
	public void initializeSet()
	{
		if(id == RandomSetID.DTRS_0)
		{
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			
			addEnemy(new Floater(Game.WIDTH - 1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH - 1, 1, ObjectType.FLOATER, handler));
			
			addEnemy(new Floater(Game.WIDTH - 1, Game.HEIGHT - 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH - 1, Game.HEIGHT - 1, ObjectType.FLOATER, handler));
			
			addEnemy(new Floater(1, Game.HEIGHT - 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, Game.HEIGHT - 1, ObjectType.FLOATER, handler));
		} else if(id == RandomSetID.DTRS_1)
		{
			addEnemy(new MonsterFloater(1, 1, ObjectType.MONSTER_FLOATER, handler));
			addEnemy(new Attacker(Game.WIDTH, Game.HEIGHT, ObjectType.MONSTER_FLOATER, handler));
		} else if(id == RandomSetID.DTRS_2)
		{
			addEnemy(new Shooter(Game.WIDTH - 1, Game.HEIGHT - 1, ObjectType.SHOOTER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
		} else if(id == RandomSetID.DTRS_3)
		{
			addEnemy(new Attacker(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.ATTACKER, handler));
			addEnemy(new Shooter(1, 1, ObjectType.SHOOTER, handler));
			addEnemy(new MonsterFloater(1, 1, ObjectType.MONSTER_FLOATER, handler));
		} else if(id == RandomSetID.DTRS_4)
		{
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
		} else if(id == RandomSetID.DTRS_5)
		{
			addEnemy(new Floater(Game.WIDTH / 2, Game.HEIGHT / 2, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, 1, ObjectType.FLOATER, handler));
			addEnemy(new Floater(1, Game.HEIGHT - 1, ObjectType.FLOATER, handler));
		} else if(id == RandomSetID.DTRS_6)
		{
			
		} else if(id == RandomSetID.DTRS_7)
		{
			
		} else if(id == RandomSetID.DTRS_8)
		{
			
		} else if(id == RandomSetID.DTRS_9)
		{
			
		} else if(id == RandomSetID.DTRS_10)
		{
			
		} else if(id == RandomSetID.DTRS_11)
		{
			
		} else if(id == RandomSetID.DTRS_12)
		{
			
		} else if(id == RandomSetID.DTRS_13)
		{
			
		} else if(id == RandomSetID.DTRS_14)
		{
			
		} else if(id == RandomSetID.DTRS_15)
		{
			
		}
	}
	

}
