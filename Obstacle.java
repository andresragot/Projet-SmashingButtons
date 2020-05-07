import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;//
import java.awt.image.*;
import java.awt.Color; 
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Obstacle extends Entite {
	
	private float x;
	private float y;
	private Jeu lejeu;
	private BufferedImage obstacle = ImageLoader.loadImage("Obstacle.png");
	
	public Obstacle(float x, float y){
		super(x,y);
	}
}

