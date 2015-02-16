package com.dodgetime.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.dodgetime.hud.HUD;
import com.dodgetime.main.Game;
import com.dodgetime.main.GameObject;
import com.dodgetime.main.Handler;
import com.dodgetime.main.ObjectType;
import com.dodgetime.objects.Trail;

public class MonsterFloater extends GameObject {
	
	Handler handler;

	public MonsterFloater(int x, int y, ObjectType type, Handler handler)
	{
		super(x, y, type);
		
		this.handler = handler;
		
		setVelX(new Random().nextInt(6));
		setVelY(new Random().nextInt(6));
	}

	public void tick()
	{
		x += velX;
		y += velY;
		
		if(x < 0 || x > 900 - 264)
		{
			if(getVelX() < 0 && getVelY() < 0)
			{
				setVelX(getVelX() * -1);
				setVelY(getVelY() * 1);
			} else if(getVelX() > 0 && getVelY() < 0)
			{
				setVelX(getVelX() * -1);
				setVelY(getVelY() * 1);
			} else if(getVelX() > 0 && getVelY() > 0)
			{
				setVelX(getVelX() * -1);
				setVelY(getVelY() * 1);
			} else if(getVelX() < 0 && getVelY() > 0)
			{
				setVelX(getVelX() * -1);
				setVelY(getVelY() * 1);
			} else if(getVelX() == 0 && getVelY() == 0)
			{
				return;
			} else if(getVelX() == 0 && getVelY() > 0)
			{
				setVelY(getVelY() * -1);
			} else if(getVelX() == 0 && getVelY() < 0)
			{
				setVelY(getVelY() * -1);
			} else if(getVelX() > 0 && getVelY() == 0)
			{
				setVelX(getVelX() * -1);
			} else if(getVelX() < 0 && getVelY() == 0)
			{
				setVelX(getVelX() * -1);
			}
		}
		
		if(y < 0 || y > Game.HEIGHT - 300)
		{
			if(getVelX() < 0 && getVelY() < 0)
			{
				setVelX(getVelX() * 1);
				setVelY(getVelY() * -1);
			} else if(getVelX() > 0 && getVelY() < 0)
			{
				setVelX(getVelX() * 1);
				setVelY(getVelY() * -1);
			} else if(getVelX() > 0 && getVelY() > 0)
			{
				setVelX(getVelX() * 1);
				setVelY(getVelY() * -1);
			} else if(getVelX() < 0 && getVelY() > 0)
			{
				setVelX(getVelX() * 1);
				setVelY(getVelY() * -1);
			} else if(getVelX() == 0 && getVelY() == 0)
			{
				return;
			} else if(getVelX() == 0 && getVelY() > 0)
			{
				setVelY(getVelY() * -1);
			} else if(getVelX() == 0 && getVelY() < 0)
			{
				setVelY(getVelY() * -1);
			} else if(getVelX() > 0 && getVelY() == 0)
			{
				setVelX(getVelX() * -1);
			} else if(getVelX() < 0 && getVelY() == 0)
			{
				setVelX(getVelX() * -1);
			}
		}
		
		handler.addObject(new Trail(x, y, ObjectType.TRAIL, handler, Color.RED, 264, 264, 0.1f));
	}

	public void render(Graphics g)
	{
		
		
		if(!HUD.images)
		{
			g.setColor(Color.RED);
			g.fillRect((int) x,(int) y, 264, 264);
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int) x,(int) y, 264, 264);
	}

}
