import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;//
import java.awt.image.*;
import java.awt.Color; 
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

public class chauveSouris extends Creature{
	Timer timer = new Timer();
	int milliseconds=0;
	TimerTask task = new TimerTask(){
		public void run(){
			milliseconds++;
		}
	};
	
	private float x; 
	private float y; 
	private int pv;
	private BufferedImage chavesouris=ImageLoader.loadImage("Bat1.png");
	private Jeu leJeu;
	
	
	public chauveSouris(Jeu jeu, float x, float y, BufferedImage creature){
		super(jeu,x,y,creature);
	}
	
	public void flick(){
		timer.scheduleAtFixedRate(task,100,100);
		if(milliseconds%100==0){
			x=x+3;
			chavesouris = ImageLoader.loadImage("bat2.png");
		}if(milliseconds%200==0){
			x=x-6;
			chavesouris = ImageLoader.loadImage("bat2.png");
		}
	}
	
	
}

