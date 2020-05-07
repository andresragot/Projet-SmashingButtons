

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * /cette classe ne sert qu'a s'en passer du try and catch a chaque fois qu'on veut 
 * charger une image dans le jeu 
 * 
 * */
public class ImageLoader {  

	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
