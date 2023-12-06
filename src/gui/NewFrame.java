import java.awt.FlowLayout;
import javax.swing.JFrame;

public class NewFrame extends JFrame
{
    //New Frame Constructor
    public NewFrame(String text)
    {
        this.setTitle(text);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        //this.setBounds(600, 500, 900, 900);
        this.setSize(900, 600);
        this.setResizable(true);
        
        //this.pack();
        this.setVisible(true);
    }
}
