import java.awt.Graphics;//


public abstract class Entite {
	
	protected float x;
	protected float y;
	protected Jeu leJeu;
	
	public Entite ( float x, float y){
		
		this.x = x;
		this.y = y;
	}
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	
	public abstract void tick();
	public abstract void render(Graphics G);
	
}

