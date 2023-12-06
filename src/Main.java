import java.util.HashMap;
import java.util.Set;
import javax.swing.JComboBox;

public class Main
{
    static HashMap <String, String[]> accountDetails = new HashMap<String, String[]>(); //Main list to be used
    //Global variables
    static TitleLabel viewTitle;
    static KeyLabel userLabel;
    static KeyLabel emailLabel;
    static KeyLabel passwordLabel;
    static KeyLabel pinLabel;
    static NewTextField titleText;
    static NewTextField userText;
    static NewTextField emailText;
    static NewTextField passwordText;
    static NewTextField pinText;
    static String original;
    private static void createAndShowGUI()
    {
        NewFrame mainWin = new NewFrame("Account Details Storage");

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
        SubFrame addWin = new SubFrame("Add New Account Detail");
        NewTextField t1 = new NewTextField("Title... ");
        NewTextField t2 = new NewTextField("Username...");
        NewTextField t3 = new NewTextField("Password... ");
        NewTextField t4 = new NewTextField("Email... ");
        NewTextField t5 = new NewTextField("Security pin... ");
        SubButton b = new SubButton("Submit");

        addWin.add(t1);
        addWin.add(t2);
        addWin.add(t3);
        addWin.add(t4);
        addWin.add(t5);
        addWin.add(b);

        b.addActionListener(e -> onSubmit(t2.getText(), t3.getText(), t4.getText(), t5.getText(), t1.getText()));
    }

    public static void openView()
    {
        SubFrame viewWin = new SubFrame("View Account Details");
        //MainButton edit = new MainButton("Edit");
    
        Set<String> temp = accountDetails.keySet();
        int n = temp.size();
        String[] Titles = new String[n];
        int i = 0;
        for (String p: temp)
        {
            Titles[i++] = p;
        }

        JComboBox<String> select = new JComboBox<String>(Titles);
        select.setEditable(true);

        viewTitle = new TitleLabel();
        emailLabel = new KeyLabel();
        userLabel = new KeyLabel();
        passwordLabel = new KeyLabel();
        pinLabel = new KeyLabel();
        viewWin.add(select);
        viewWin.add(viewTitle);
        viewWin.add(emailLabel);
        viewWin.add(userLabel);
        viewWin.add(passwordLabel);
        viewWin.add(pinLabel);
        //viewWin.add(selectLabel);
        //viewWin.add(edit);
        select.addActionListener(e -> onViewSelect(select.getSelectedItem().toString()));
    }

    public static void openEdit()
    {
        Set<String> temp = accountDetails.keySet();
        int n = temp.size();
        String[] Titles = new String[n];
        int i = 0;
        for (String p: temp)
        {
            Titles[i++] = p;
        }

        SubFrame editWin = new SubFrame("Edit Account Details");
        JComboBox<String> select = new JComboBox<String>(Titles);
        select.setEditable(true);

        titleText = new NewTextField("N/A");
        emailText = new NewTextField("N/A");
        userText = new NewTextField("N/A");
        passwordText = new NewTextField("N/A");
        pinText = new NewTextField("N/A");

        SubButton submit = new SubButton("Submit");

        editWin.add(submit);
        editWin.add(select);
        editWin.add(titleText);
        editWin.add(emailText);
        editWin.add(userText);
        editWin.add(pinText);
        editWin.add(passwordText);

        select.addActionListener(e -> onEditSelect(select.getSelectedItem().toString()));


        submit.addActionListener(e -> onEdit(original, emailText.getText(), userText.getText(), passwordText.getText(), pinText.getText(), titleText.getText()));
    }

    public static void onSubmit(String user, String password, String email, String pin, String title)
    {
        accountDetails.put(title, new String[]{email, user, pin, password}); //Adds the info to the HashMap
        openView();
    }

    public static void onViewSelect(String item)
    {
        String[] buffer = accountDetails.get(item);
        viewTitle.setText(item);
        emailLabel.setText(buffer[0]);
        userLabel.setText(buffer[1]);
        pinLabel.setText(buffer[2]);
        passwordLabel.setText(buffer[3]);
    }

    public static void onEditSelect(String item)
    {
        original = item;
        String[] buffer = accountDetails.get(item);
        titleText.setText(item);
        emailText.setText(buffer[0]);
        userText.setText(buffer[1]);
        pinText.setText(buffer[2]);
        passwordText.setText(buffer[3]);
    }

    public static void onEdit(String og, String email, String user, String pass, String pin, String title)
    {
        String[] temp = accountDetails.get(og);
        temp[0] = email;
        temp[1] = user;
        temp[2] = pin;
        temp[3] = pass;
        accountDetails.remove(og);
        accountDetails.put(title, temp);
    }

  public static void main(String[] args)
  {
    createAndShowGUI();
  }
}
