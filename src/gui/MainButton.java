import javax.swing.JButton;
import javax.swing.border.Border;

public class MainButton extends JButton
{
    public MainButton()
    {
        Border border = BorderFactory.createLineBorder(Color.BLUE);
        this.setBorder(border);
        this.setPreferredSize(new Dimension(300, 50));
        this.setHorizontalTextPosition(JButton.CENTER);
    }
}
