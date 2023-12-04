import javax.swing.JButton;
import javax.swing.border.Border;

public class SubButton extends JButton
{
    public SubButton()
    {
        Border border = BorderFactory.createLineBorder(Color.YELLOW);
        this.setBorder(border);
        this.setPreferredSize(new Dimension(300, 100));
        this.setHorizontalTextPosition(JButton.CENTER);
    }
}
