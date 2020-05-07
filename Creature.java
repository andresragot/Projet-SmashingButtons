import java.awt.Graphics;//
import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color; 
import java.awt.image.BufferStrategy;

public class Creature {
	private float x; 
	private float y; 
	private int pv;
	private BufferedImage creature;
	private Jeu leJeu;
	
	
	public Creature (Jeu jeu, float x, float y, BufferedImage creature){
		this.x = x;
		this.y = y;
		leJeu = jeu;
		this.creature=creature;
	}
	
	public void render (Graphics g){
		g.drawImage(creature, (int) x , (int) y,null);
	}
}

