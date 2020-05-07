import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;//
import java.awt.image.*;
import java.awt.Color; 
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

public class  Monstre extends Creature {
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
	private BufferedImage monstre = ImageLoader.loadImage("Monstro.png");
	private Jeu leJeu; 
	
	
	public Monstre(Jeu jeu, float x, float y, BufferedImage Monstro){
		super(jeu,x,y,Monstro);
	}
	
	public void flick(){
		timer.scheduleAtFixedRate(task,100,100);
		if(milliseconds%100==0){
			y=y+3;
		}if(milliseconds%200==0){
			y=y-6;
		}
	}

}

