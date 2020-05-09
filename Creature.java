import java.awt.Graphics;//

public abstract class Creature extends Entite {
	public static final int PV_PAR_DEFAUT = 10;
	public static final float VITESSE_PAR_DEFAUT = 3.0f;
	public static final int TAILLE_DEFAUT_LARGEUR = 32;
	public static final int TAILLE_DEFAUT_HAUTEUR = 32;
	
	protected int pV;
	protected float vitesse;
	protected float xBouge,yBouge;
	
	public Creature ( float x, float y, int largeur, int hauteur){
		super(x, y, hauteur, largeur);
		pV= PV_PAR_DEFAUT;
		vitesse = VITESSE_PAR_DEFAUT;
		xBouge = 0;
		yBouge = 0;
	}
	
	public void bouger(){
		x += xBouge;
		y += yBouge;
	}
	
	
	//getteurs et setteurs
	public float getXBouge(){
		return xBouge;
	}
	public  void setXBouge(float bouge){
		xBouge = bouge;
	}
	
	
	public float getYBouge(){
		return yBouge;
	}
	public  void setYBouge(float bouge){
		yBouge = bouge;
	}
	
	
	public int getPV(){
		return pV;
	}
	public void setPV(int p){
		pV = p;
	}
	
	public float getVitesse(){
		return vitesse;
	}
	public void setVitesse(int v){
		vitesse = v;
	}
	
	
}

