import javax.swing.JFrame;

public class NewFrame extends JFrame
{
    //New Frame Constructor
    public NewFrame()
    {
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setSize(600, 360);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
