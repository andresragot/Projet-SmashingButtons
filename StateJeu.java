import java.awt.Graphics;//
import java.awt.image.*;

import java.awt.Color; 
import java.awt.image.BufferStrategy;
/*
 */


public class StateJeu extends State {
	//===========Assets===========//
	//private BufferedImage player = ImageLoader.loadImage("player.png");
	//private BufferedImage mur = ImageLoader.loadImage("MURO.png");
	//============================//
	private Player player;
	
	
	public StateJeu(Jeu jeu){
		super (jeu);
		player  = new Player(jeu, 50,50);
	}
	
	public void tick(){
		player.tick();
	}
	public void render(Graphics g){
		player.render(g);
	}
	
}

