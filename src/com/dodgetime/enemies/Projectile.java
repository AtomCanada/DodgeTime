package com.dodgetime.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.dodgetime.hud.HUD;
import com.dodgetime.main.Game;
import com.dodgetime.main.GameObject;
import com.dodgetime.main.Handler;
import com.dodgetime.main.ObjectType;

public class Projectile extends GameObject {
	
	Handler handler;
	Color color;
	
	GameObject targetPlayer;
	
	public Projectile(float x, float y, ObjectType type, Handler handler, Color color)
	{
		super(x, y, type);
		
		this.handler = handler;
		
		this.color = color;
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject object = handler.object.get(i);
			if(object.getType() == ObjectType.PLAYER)
			{
				targetPlayer = object;
			}
		}
		
		float difX = x - targetPlayer.getX();
		float difY = y - targetPlayer.getY();
		
		float distance = (float) Math.sqrt((x - targetPlayer.getX()) * (x - targetPlayer.getX()) + (y - targetPlayer.getY()) * (y - targetPlayer.getY()));
		
		velX = (-1 / distance) * difX * 10;
		velY = (-1 / distance) * difY * 10;
	}

	public void tick()
	{
		x += velX;
		y += velY;
		
		if(y < 0 || y > Game.HEIGHT)
		{
			handler.removeObject(this);
		}
		
		if(x < 0 || x > Game.WIDTH)
		{
			handler.removeObject(this);
		}
		
		//handler.addObject(new Trail(x, y, ObjectType.TRAIL, handler, color, 8, 8, 0.1f));
	}

	public void render(Graphics g)
	{
		if(!HUD.images)
		{
			g.setColor(color);
			g.fillRect((int) x,(int) y, 8, 8);
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int) x,(int) y, 48, 48);
	}

}
