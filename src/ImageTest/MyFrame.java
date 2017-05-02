package ImageTest;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
  
public class MyFrame extends Frame{  
      
    public MyFrame(Image image) {  
  
        // 默认的窗体名称  
        this.setTitle("Canny处理图片");  
  
        // 获得面板的实例  
        MyPanel panel = new MyPanel(image);  
        this.add(panel);  
        this.addWindowListener(new WindowAdapter() {  
            //设置关闭  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });  
        // 执行并构建窗体设定  
        this.pack();  
        this.setVisible(true);  
    }  
  
} 
