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

public class Attacker extends GameObject {
	
	Handler handler;
	
	GameObject targetPlayer;
	
	public Attacker(float x, float y, ObjectType type, Handler handler)
	{
		super(x, y, type);
		
		this.handler = handler;
		
		setVelX(5);
		setVelY(5);
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject object = handler.object.get(i);
			if(object.getType() == ObjectType.PLAYER)
			{
				targetPlayer = object;
			}
		}
	}

	public void tick()
	{
		x += velX;
		y += velY;
		
		if(x < 0 || x > 900 - 32)
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
		
		if(y < 0 || y > Game.HEIGHT - 55)
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
		
		if(new Random().nextInt(10) == 0)
		{
			float difX = x - targetPlayer.getX();
			float difY = y - targetPlayer.getY();
			
			float distance = (float) Math.sqrt((x - targetPlayer.getX()) * (x - targetPlayer.getX()) + (y - targetPlayer.getY()) * (y - targetPlayer.getY()));
			
			velX = (-1 / distance) * difX * 4;
			velY = (-1 / distance) * difY * 4;
			
		}
		
		handler.addObject(new Trail(x, y, ObjectType.TRAIL, handler, Color.BLUE, 32, 32, 0.03f));
	}

	public void render(Graphics g)
	{
		if(!HUD.images)
		{
			g.setColor(Color.BLUE);
			g.fillRect((int) x,(int) y, 32, 32);
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int) x,(int) y, 48, 48);
	}

}
