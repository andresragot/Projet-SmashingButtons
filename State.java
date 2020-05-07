/*
 *
 * 
 * 
 */
import java.awt.Graphics;

public abstract class State {
	private static State currentState = null; 
	protected Jeu leJeu;
	
	public State(Jeu jeu){
		leJeu = jeu;
	}
	
	public static void setState (State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
}

