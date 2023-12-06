import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class TitleLabel extends JLabel 
{
    public TitleLabel()
    {
        this.setText("(N/A)");
        this.setForeground(Color.BLUE);
        this.setFont(new Font("MV Boli", Font.PLAIN, 42));
    }
}
