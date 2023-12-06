import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JButton;

public class SubButton extends JButton
{
    public SubButton(String text)
    {
        this.setText(text);
        Border border = BorderFactory.createLineBorder(Color.YELLOW);
        this.setBorder(border);
        this.setPreferredSize(new Dimension(300, 100));
        this.setHorizontalTextPosition(JButton.CENTER);
    }
}
