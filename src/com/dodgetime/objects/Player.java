package com.dodgetime.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import com.dodgetime.hud.HUD;
import com.dodgetime.main.Game;
import com.dodgetime.main.GameObject;
import com.dodgetime.main.Handler;
import com.dodgetime.main.ObjectType;

public class Player extends GameObject {

	Handler handler;
	boolean contact;
	
	public Player(float x, float y, ObjectType type, Handler handler)
	{
		super(x, y, type);
		this.handler = handler;
	}

	public void tick()
	{
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		handler.addObject(new Trail(x, y, ObjectType.TRAIL, handler, Color.WHITE, 32, 32, 0.1f));
		
		collision();
	}
	
	private void collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getType() == ObjectType.FLOATER)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{					
					//Collision
					HUD.HEALTH -= 1;
					HUD.contact = true;
				} else
				{
					HUD.contact = false;
				}
			} else if(tempObject.getType() == ObjectType.MONSTER_FLOATER)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{					
					//Collision
					HUD.HEALTH -= 1;
					HUD.contact = true;
				} else
				{
					HUD.contact = false;
				}
			} else if(tempObject.getType() == ObjectType.ATTACKER)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{					
					//Collision
					HUD.HEALTH -= 1;
					HUD.contact = true;
				} else
				{
					HUD.contact = false;
				}
			} else if(tempObject.getType() == ObjectType.PROJECTILE)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{					
					//Collision
					HUD.HEALTH -= 1;
					HUD.contact = true;
				} else
				{
					HUD.contact = false;
				}
			}
		}
	}
	

	public void render(Graphics g)
	{	
		
		if(!HUD.images)
		{
			if(contact)
			{
				g.setColor(Color.ORANGE);
				g.fillRect((int) x, (int) y, 32, 32);
			} else
			{
				g.setColor(Color.WHITE);
				g.fillRect((int) x, (int) y, 32, 32);
			}
		}
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int) x, (int) y, 32, 32);
	}

}
