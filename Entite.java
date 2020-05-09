import java.awt.Graphics;//


public abstract class Entite {
	
	protected float x;
	protected float y;
	protected int largeur;
	protected int hauteur;
	
	public Entite ( float x, float y, int largeur, int hauteur){
		
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		
	}
	
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public float getX (){
		return x;
	}
	
	public void setX(float x){
		this.x=x;
	}
	
	
	public float getY(){
		return y;
	}
	public void setY(float y){
		this.y=y;
	}
	
	public int getLargeur(){
		return largeur;
	}
	public void setLargeur(int l){
		largeur = l;
	}
	
	public int getHauteur(){
		return hauteur;
	}
	public void setHauteur(int h){
		hauteur = h;
	}
	
}

