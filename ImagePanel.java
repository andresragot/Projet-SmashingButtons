import java.lang.Object;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ImagePanel{

	public static void main (String []args){
	
	File imagefile = new File ("PixelArt.png");
	BufferedImage image = ImageIO.read(imagefile);
	}
}
