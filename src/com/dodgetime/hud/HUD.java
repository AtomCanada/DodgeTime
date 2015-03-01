package com.dodgetime.hud;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import com.dodgetime.enemies.Spawn;
import com.dodgetime.main.Game;
import com.dodgetime.main.Handler;

public class HUD {
	
	public static float HEALTH = 100;
	private int greenValue = 255;
	
	public static int seconds = 290;
	public static boolean counting = true;
	private int level = 1;
	public static boolean regening = false;
	
	public static boolean contact = false;
	
	Spawn spawner = new Spawn(new Handler(), this);
	
	public static boolean images = false;
	
	public void tick()
	{
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = (int) Game.clamp(greenValue, 0, 255);
		greenValue = (int) HEALTH * 2;
		
		if(regening)
		{
			if(new Random().nextInt(5) == 1)
			{
				HEALTH += 1;
			}
		}
	}
	
	public void render(Graphics g)
	{
		try
		{			
			
			g.setColor(Color.GRAY);
			g.fillRect(20, 10, 200, 40);
			
			g.setColor(new Color(75, greenValue, 0));
			g.fillRect(20, 10, (int) HEALTH * 2, 40);
			
			g.setColor(Color.WHITE);
			g.drawRect(20, 10, 200, 40);
			
			g.setFont(new Font("Courier new", Font.BOLD, 20));
			g.drawString("HEALTH", 85, 35);
			
			g.drawString("Time: " + seconds, 400, 40);
			g.drawString("Level: " + getLevel(), 750, 40);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}

}
