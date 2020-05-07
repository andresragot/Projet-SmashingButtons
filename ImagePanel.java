import java.lang.Object;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePanel{

	public static void main (String []args){
	
	File imagefile = new File ("PixelArt.png");
	BufferedImage image = ImageIO.read(imagefile);
	}
}
