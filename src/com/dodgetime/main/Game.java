package com.dodgetime.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.dodgetime.enemies.Attacker;
import com.dodgetime.enemies.Floater;
import com.dodgetime.enemies.MonsterFloater;
import com.dodgetime.enemies.Shooter;
import com.dodgetime.enemies.Spawn;
import com.dodgetime.hud.HUD;
import com.dodgetime.input.KeyInput;
import com.dodgetime.objects.Player;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 8728374592718148229L;

	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	
	public static void main(String[] args)
	{
		new Game();
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public static float clamp(float var, float min, float max)
	{
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;		
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
			running = false;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				delta--;				
			}
			if(running) render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
				runStart();
			}
		}
		stop();
	}
	
	private void tick()
	{
		handler.tick();
		hud.tick();
		spawner.tick();
		
		if(HUD.HEALTH <= 0)
		{
			HUD.HEALTH = 100;
			BufferStrategy bs = this.getBufferStrategy();
			if(bs == null)
			{
				this.createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
				
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public Game()
	{
		hud = new HUD();		
		handler = new Handler();
		spawner = new Spawn(handler, hud);
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "DodgeTime", this);		
		
		handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ObjectType.PLAYER, handler));
		handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
		handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
		handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
	}
	
	public void runStart()
	{
		if(HUD.counting)
		{
			HUD.seconds = HUD.seconds + 1;					
			spawner.setTimeKeep(spawner.getTimeKeep() + 1);
			
			if(Integer.toString(spawner.getTimeKeep()).endsWith("0") && spawner.getTimeKeep() < 51)
			{
				handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
			}
			
			if(spawner.getTimeKeep() >= 60 && spawner.getTimeKeep() <= 65)
			{
				HUD.regening = true;
				for(int i = 0; i < handler.object.size(); i++)
				{
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getType() == ObjectType.FLOATER)
					{
						handler.removeObject(tempObject);
					}
				}
			}
			
			if(spawner.getTimeKeep() == 66)
			{
				HUD.regening = false;
				handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(WIDTH - 33, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(WIDTH - 33, HEIGHT - 55, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(33, HEIGHT - 55, ObjectType.FLOATER, handler));
				
				handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(WIDTH - 33, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(WIDTH - 33, HEIGHT - 55, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(33, HEIGHT - 55, ObjectType.FLOATER, handler));
			
				
				hud.setLevel(hud.getLevel() + 1);
			}
			
			if(spawner.getTimeKeep() >= 95 && spawner.getTimeKeep() <= 100)
			{
				HUD.regening = true;
				for(int i = 0; i < handler.object.size(); i++)
				{
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getType() == ObjectType.FLOATER)
					{
						handler.removeObject(tempObject);
					}
				}
			}
			
			if(spawner.getTimeKeep() == 101)
			{
				HUD.regening = false;
				handler.addObject(new MonsterFloater(100, 100, ObjectType.MONSTER_FLOATER, handler));
				handler.addObject(new MonsterFloater(100, 100, ObjectType.MONSTER_FLOATER, handler));
								
				hud.setLevel(hud.getLevel() + 1);
			}
			
			if(spawner.getTimeKeep() >= 120 && spawner.getTimeKeep() <= 125)
			{
				HUD.regening = true;
				for(int i = 0; i < handler.object.size(); i++)
				{
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getType() == ObjectType.MONSTER_FLOATER)
					{
						handler.removeObject(tempObject);
					}
				}
			}
			
			if(spawner.getTimeKeep() == 126)
			{
				HUD.regening = false;
				handler.addObject(new Attacker(1, 1, ObjectType.ATTACKER, handler));
				handler.addObject(new Attacker(WIDTH - 32, HEIGHT - 55, ObjectType.ATTACKER, handler));
				handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(1, 200, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(1, 400, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(1, 600, ObjectType.FLOATER, handler));
				
				hud.setLevel(hud.getLevel() + 1);
			}
			
			if(spawner.getTimeKeep() >= 150 && spawner.getTimeKeep() <= 155)
			{
				HUD.regening = true;
				for(int i = 0; i < handler.object.size(); i++)
				{
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getType() == ObjectType.ATTACKER || tempObject.getType() == ObjectType.FLOATER)
					{
						handler.removeObject(tempObject);
					}
				}
			}
			
			if(spawner.getTimeKeep() == 156)
			{
				HUD.regening = false;
				
				handler.addObject(new Shooter(WIDTH / 2 - 48, HEIGHT / 2 - 48, ObjectType.SHOOTER, handler));
				handler.addObject(new Attacker(1, 1, ObjectType.ATTACKER, handler));
				
				hud.setLevel(hud.getLevel() + 1);
			}
			
			if(spawner.getTimeKeep() >= 195 && spawner.getTimeKeep() <= 200)
			{
				HUD.regening = true;
				for(int i = 0; i < handler.object.size(); i++)
				{
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getType() == ObjectType.ATTACKER || tempObject.getType() == ObjectType.SHOOTER)
					{
						handler.removeObject(tempObject);
					}
				}
			}
			
			if(spawner.getTimeKeep() == 201)
			{
				HUD.regening = false;
				
				handler.addObject(new MonsterFloater(1, 1, ObjectType.MONSTER_FLOATER, handler));
				handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(1, 1, ObjectType.FLOATER, handler));
				
				hud.setLevel(hud.getLevel() + 1);
			}
			
			if(spawner.getTimeKeep() >= 230 && spawner.getTimeKeep() <= 235)
			{
				HUD.regening = true;
				for(int i = 0; i < handler.object.size(); i++)
				{
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getType() == ObjectType.MONSTER_FLOATER || tempObject.getType() == ObjectType.FLOATER)
					{
						handler.removeObject(tempObject);
					}
				}
			}
			
			if(spawner.getTimeKeep() == 236)
			{
				HUD.regening = false;
				
				handler.addObject(new Attacker(WIDTH - 1, HEIGHT - 1, ObjectType.ATTACKER, handler));
				handler.addObject(new Shooter(1, 1, ObjectType.SHOOTER, handler));
				handler.addObject(new Floater(WIDTH - 1, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(WIDTH - 1, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(WIDTH - 1, 1, ObjectType.FLOATER, handler));
				handler.addObject(new Floater(WIDTH - 1, 1, ObjectType.FLOATER, handler));
				
				hud.setLevel(hud.getLevel() + 1);
			}
			
			if(spawner.getTimeKeep() >= 295 && spawner.getTimeKeep() <= 300)
			{
				HUD.regening = true;
				for(int i = 0; i < handler.object.size(); i++)
				{
					GameObject tempObject = handler.object.get(i);
					if(tempObject.getType() == ObjectType.ATTACKER || tempObject.getType() == ObjectType.SHOOTER || tempObject.getType() == ObjectType.FLOATER)
					{
						handler.removeObject(tempObject);
					}
				}
			}
			
			if(spawner.getTimeKeep() == 301)
			{
				HUD.regening = false;				
				hud.setLevel(hud.getLevel() + 1);
				
				
			}
		}
	}
	
}
