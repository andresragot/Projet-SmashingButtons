import java.awt.Graphics;//
<<<<<<< HEAD
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
=======

public abstract class Creature extends Entite {
	
	protected int pV;
	
	public Creature ( float x, float y){
		super( x, y);
		pV=10;
	}
	
>>>>>>> 3e6a947fd996b3e5bf63fb2d57d8c04e8ccca7f7
}
