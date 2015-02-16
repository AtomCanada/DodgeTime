package com.dodgetime.objects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.dodgetime.hud.HUD;
import com.dodgetime.main.GameObject;
import com.dodgetime.main.Handler;
import com.dodgetime.main.ObjectType;

public class Trail extends GameObject {

	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width, height;
	private float life;
	
	public Trail(float x, float y, ObjectType type, Handler handler, Color color, int width, int height, float life)
	{
		super(x, y, type);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	public void tick()
	{
		if(alpha > life)
		{
			alpha -= life - 0.001f;
		} else handler.removeObject(this);
	}
	
	private AlphaComposite makeTransparent(float alpha)
	{
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, alpha);
	}

	public void render(Graphics g)
	{
		if(!HUD.images)
		{
			Graphics2D g2 = (Graphics2D) g;
			g2.setComposite(makeTransparent(alpha));
			
			g.setColor(color);
			g.fillRect((int) x, (int) y, width, height);

			g2.setComposite(makeTransparent(1));
		}
	}
	public Rectangle getBounds()
	{
		return null;
	}

}
