import java.awt.Dimension;
import javax.swing.JTextField;

public class NewTextField extends JTextField
{

    public NewTextField(String text)
    {
        this.setText(text);
        this.setPreferredSize(new Dimension(400, 40));
    }
}
