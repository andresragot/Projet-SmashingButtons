
import java.awt.*;
import java.awt.image.*;

import java.awt.Color; //
import java.awt.Graphics;//
import java.awt.image.BufferStrategy;//

<<<<<<< HEAD
	public void bouger(int c, int l){
=======
public class Jeu implements Runnable{
	
	private Affichage affichage;
	
	private String titre;
	private int hauteur;
	private int largeur;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//===========Assets===========//
	private BufferedImage player = ImageLoader.loadImage("player.png");
	private BufferedImage mur = ImageLoader.loadImage("MURO.png");
	//============================//
	
	//States
	private State stateJeu;
	private State stateMenu;
	
	//input
	private KeyManager keyManager;
	
	public Jeu(String nom, int h, int l){
		
		hauteur = h; 
		largeur = l;
		titre=nom;
		keyManager = new KeyManager();
		
>>>>>>> 25b6dda3aa98d6ea54b8f7bc7203dec0bb9ed8d1
	}
	
	
	private void init(){
		affichage = new Affichage (titre ,hauteur, largeur);
		affichage.getFrame().addKeyListener(keyManager);
		
		stateJeu = new StateJeu(this);
		stateMenu = new StateMenu(this);
		State.setState(stateJeu);
		
		/*affichage.getFrame().addKeyListener(keyManager);
		Assets.init();
		*/
	}
	
<<<<<<< HEAD

	public boolean bougerPossible(int c, int l){
		return true;
=======
	private void tick(){
		keyManager.tick();
		if (State.getState() != null){
			State.getState().tick();
		}
>>>>>>> 25b6dda3aa98d6ea54b8f7bc7203dec0bb9ed8d1
	}
	int x = 0;
	private void render(){
		bs = affichage.getCanvas().getBufferStrategy();
		if (bs == null){
			affichage.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); //g es el Pincel
		g.clearRect(0,0,largeur,hauteur);
		//========Zone pour g=========
		g.fillRect(0,0, largeur, hauteur);
		
		if (State.getState() != null){
			State.getState().render(g);
		}
		
		
		//============================
		bs.show();
		g.dispose(); //pour finir de dessiner 
	}
	public void run(){
		
		
		init ();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps ;
		double delta = 0;
		long now ;
		long lastTime = System.nanoTime();
		
		
		
		long timer = 0;
		int ticks = 0;
		
		while(running){ //loop
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now -lastTime;
			lastTime = now;
			
			if (delta >= 1){
				tick();//<----------------tick et render
				render();
				
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000){
				System.out.println("Ticks et Fps: "+ticks);
				timer = 0;
				ticks = 0;
			}
			
		}
		
		stop(); //au cas ou 
		
	}
	public KeyManager getKeyManager(){
		return keyManager;
	}
	public synchronized void start(){
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();//appelle la methode run()
	}
	
	
	public synchronized void stop(){ //termine le fil 
		if(!running) return;
		
		running = false; 
		try {
			thread.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
}

