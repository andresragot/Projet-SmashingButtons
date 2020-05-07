import java.awt.Graphics;//

public abstract class Creature extends Entite {
	
	protected int pV;
	
	public Creature ( float x, float y){
		super( x, y);
		pV=10;
	}
	
}

