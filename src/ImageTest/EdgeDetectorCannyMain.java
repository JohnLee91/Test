package ImageTest;

import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EdgeDetectorCannyMain {
	public static void main(String[] args) throws IOException {
		EdgeDetectorCanny edgeDetector=new EdgeDetectorCanny();
	    File file = new File(System.getProperty("user.dir")+"/images/6.jpg");  
	    BufferedImage image = ImageIO.read(file);  
        edgeDetector.setSourceImage(image);
        edgeDetector.setThreshold(128);
        edgeDetector.setWidGaussianKernel(5);
        try {
            edgeDetector.process();
        }
        catch(EdgeDetectorCannyException e) {
            System.out.println(e.getMessage());
        }
        Image edgeImage=edgeDetector.getEdgeImage();
        Frame frame=new MyFrame(edgeImage);     
        
    } 
  

}
