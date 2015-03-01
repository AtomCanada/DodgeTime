package com.dodgetime.enemies;

import com.dodgetime.hud.HUD;
import com.dodgetime.main.Handler;

public class Spawn {
	
	Handler handler;
	HUD hud;
	
	public int timeKeep = 290;
	
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick()
	{
		
	}
	
	public void setTimeKeep(int timeKeep)
	{
		this.timeKeep = timeKeep;
	}
	
	public int getTimeKeep()
	{
		return timeKeep;
	}

}
