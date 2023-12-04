import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Main 
{
    static HashMap <String, String[]> accountDetails = new HashMap<String, String[]>(); //Main list to be used
    NewFrame viewWin;
    NewFrame editWin;
    NewFrame mainWin;
    static int key;
    private static void createAndShowGUI() 
    {
        NewFrame mainWin = new MainFrame("Account Details Storage");

        //JLabel label = new JLabel("Hello World Swing");
        MainButton add = new MainButton("Add Account Details");
        MainButton view = new MainButton("View Account Details");
        MainButton edit = new MainButton("Edit Account Details");

        //Enable event listeners for the buttons
        add.addActionListener(e -> openAdd());
        view.addActionListener(e -> openView());
        edit.addActionListener(e -> openEdit());

        mainWin.add(view);
        mainWin.add(add);
        mainWin.add(edit);
    }

    public static void openAdd()
    {
        NewFrame addWin = new NewFrame("Add New Account Detail");
        NewTextField title = new NewTextField("Title... ");
        NewTextField username = new NewTextField("Username...");
        NewTextField password = new NewTextField("Password... ");
        NewTextField email = new NewTextField("Email... ");
        NewTextField pin = new NewTextField("Security pin... ");
        SubButton submit = new SubButton("Submit");

        addWin.add(title);
        addWin.add(username);
        addWin.add(password);
        addWin.add(email);
        addWin.add(pin);
        addWin.add(submit);
        
        submit.addActionListener(e -> onSubmit(username.getText(), password.getText(), email.getText(), pin.getText(), title.getText()));
    }

    public static void openView()
    {
        NewFrame viewWin = new NewFrame("View Account Details");
        //MainButton edit = new MainButton("Edit");
        NewComboBox select = new NewComboBox(accountDetails.keySet());
        TitleLabel title = new TitleLabel();
        KeyLabel email = new KeyLabel();
        KeyLabel username = new KeyLabel();
        KeyLabel password = new KeyLabel();
        KeyLabel pin = new KeyLabel();
        viewWin.add(title);
        viewWin.add(email);
        viewWin.add(username);
        viewWin.add(password);
        viewWin.add(pin);
        viewWin.add(select);
        //viewWin.add(edit);
        select.addActionListener(e -> onSelectView(select.getSelectedItem()));
    }

    public static void openEdit()
    {
        NewFrame editWin = new NewFrame("Edit Account Details");
        NewComboBox select = new NewComboBox(accountDetails.keySet());
        editWin.add(select);

        NewTextField title = new NewTextField();
        NewTextField email = new NewTextField();
        NewTextField username = new NewTextField();
        NewTextField password = new NewTextField();
        NewTextField pin = new NewTextField();

        SubButton sub = new SubButton("Submit");
        
        select.addActionListener(e -> onEditSelect(select.getSelectedItem(), select.getSelectedIndex()));
        
        sub.addActionListener(e -> onEdit(key, title.getText(), email.getText(), username.getText(), password.getText(), pin.getText())));
    }

    public static void onSubmit(String user, String password, String email, String pin, String title)
    {
        accountDetails.put(title, new String[]{email, user, pin, password}); //Adds the info to the HashMap
        openView();
    }

    public static void onViewSelect(String item)
    {
        String[] buffer = accountDetails.get(item);
        title.setText(item);
        email.setText(buffer[0]);
        username.setText(buffer[1]);
        pin.setText(buffer[2]);
        password.setText(buffer[3]);
    }

    public static void onEditSelect(String item, int index)
    {
        key = index;
        String[] buffer = accountDetails.get(item);
        title.setText(item);
        email.setText(buffer[0]);
        username.setText(buffer[1]);
        pin.setText(buffer[2]);
        password.setText(buffer[3]); 
    }

    public static void onEdit(int index, String email, String user, String pass, String pin, String title)
    {
        accountDetails.getKeys(index).set(title);
        accountDetails.get(index)[0].set(email);
        accountDetails.get(index)[1].set(user);
        accountDetails.get(index)[2].set(pin);
        accountDetails.get(index)[3].set(pass);
    }
    
  public static void main(String[] args) 
  {
    createAndShowGUI();
  }
}
