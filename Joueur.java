import java.awt.Graphics;//
import java.awt.image.*;

import java.awt.Color; 
import java.awt.image.BufferStrategy;
/*
 * 
 */


public class Joueur extends Creature{
	
	private BufferedImage player = ImageLoader.loadImage("player.png");
	private Jeu leJeu;
	
	public Joueur ( Jeu jeu, float x, float y){
		super( x, y);
		leJeu = jeu;
	}
	
	public void tick() {
		
		if (leJeu.getKeyManager().up) y -=3;
		if (leJeu.getKeyManager().down) y +=3;
		if (leJeu.getKeyManager().left) x -=3;
		if (leJeu.getKeyManager().right) x +=3;
	}
	public void render (Graphics g){
		g.drawImage(player, (int) x , (int) y, null);
	}
}

