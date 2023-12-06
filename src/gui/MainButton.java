import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;

public class MainButton extends JButton
{
    public MainButton(String title)
    {
        this.setText(title);
        Border border = BorderFactory.createLineBorder(Color.BLUE);
        this.setBorder(border);
        this.setPreferredSize(new Dimension(300, 50));
        this.setHorizontalTextPosition(JButton.CENTER);
    }
}
