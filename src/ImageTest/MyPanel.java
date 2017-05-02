package ImageTest;

import java.awt.Dimension;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.Image;  
import java.awt.Panel;  
import java.awt.image.BufferedImage;  
  
import javax.swing.ImageIcon;  
  
  
public class MyPanel extends Panel{  
      
    private final Image screenImage = new BufferedImage(1200, 800, 2);  
      
    private final Graphics2D screenGraphic = (Graphics2D) screenImage  
    .getGraphics();  
      
    private Image backgroundImage;  
      
    public MyPanel(Image image) {  
    	backgroundImage = image;
        //loadImage();  
        // 设定焦点在本窗体  
        setFocusable(true);  
        // 设定初始构造时面板大小,这里先采用图片的大小  
        setPreferredSize(new Dimension(1200,800));  
        // 绘制背景  
        drawView();  
    }  
      
    /** 
     * 载入图像 
     */  
    private void loadImage() {  
        //获得当前类对应的相对位置image文件夹下的背景图像  
        ImageIcon icon = new ImageIcon(getClass().getResource("../image/background.jpg"));  
        //将图像实例赋给backgroundImage  
        backgroundImage = icon.getImage();  
    }  
      
    private void drawView() {  
        screenGraphic.drawImage(backgroundImage, 0, 0, null);  
    }  
      
    public void paint(Graphics g) {  
        g.drawImage(screenImage, 0, 0, null);  
    }  
      
}  