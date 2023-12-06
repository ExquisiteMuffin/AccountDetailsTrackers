import java.awt.FlowLayout;
import javax.swing.JFrame;

public class SubFrame extends JFrame
{
    //New Frame Constructor
    public SubFrame(String text)
    {
        this.setTitle(text);
        this.setLayout(new FlowLayout());
        //this.setBounds(600, 500, 900, 900);
        this.setSize(900, 600);
        this.setResizable(true);
        
        //this.pack();
        this.setVisible(true);
    }
}
