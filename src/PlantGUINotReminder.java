// The main reason this is a main fucntion is because its mostly to experiment and learn about the swing library. 
// 
// Helpful link to get the boxes to click, particularly the last one to switch between different tabs like view, my plants, add plant:
// https://www.guru99.com/java-swing-gui.html (This program does not have code implemented for the tabs yet)
import javax.swing.*;///
import java.awt.*;

class gui{
    public static void main(String args[]){
       JFrame frame = new JFrame("Plant Watering Reminder");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JButton button1 = new JButton("Button 1"); 
       button1.setBounds(100,100,100, 40);//x axis, y axis, width, height
       JButton button2 = new JButton("Button 2");
       button2.setBounds(230,100,100, 40);//x axis, y axis, width, height
       frame.getContentPane().add(button1); // Adds Button to content pane of frame
       frame.getContentPane().add(button2); // Adds Button to content pane of frame
       frame.setSize(800,800); // Sets the size of the used window
       
       frame.setLayout(null);
       frame.setVisible(true);
    }
}