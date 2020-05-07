import java.awt.Graphics;
import java.awt.image.*;

import java.awt.Color; 
import java.awt.image.BufferStrategy;

public class Player{
	private float x; 
	private float y; 
	private int pv;
	private BufferedImage player = ImageLoader.loadImage("player.png");
	private Jeu leJeu;
	
	public Player (Jeu jeu, float x, float y){
		this.x = x;
		this.y = y;
		leJeu = jeu;
		
	}
	public void tick() {
		if (leJeu.getKeyManager().up) y -=3;
		if (leJeu.getKeyManager().down) y +=3;
		if (leJeu.getKeyManager().left) x -=3;
		if (leJeu.getKeyManager().right) x +=3;
	}
	public void render (Graphics g){
		g.drawImage(player, (int) x , (int) y,null);
	}
}

