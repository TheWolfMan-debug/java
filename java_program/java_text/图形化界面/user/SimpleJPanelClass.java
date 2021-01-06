import javax.swing.*;
/**
 * SimpleJPanelClass
 */
public class SimpleJPanelClass extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel nameLabel, passwordLabel;
    JTextField name;
    JPasswordField password;
    JButton okButton,cancelButton;

    public SimpleJPanelClass() {
        nameLabel = new JLabel("Name:");
        passwordLabel = new JLabel("Password:");
        name = new JTextField(20);
        password = new JPasswordField(20);
        okButton = new JButton("Ok");

        cancelButton = new JButton("Cancel");

        add(nameLabel);
        add(name);
        add(passwordLabel);
        add(password);
        add(okButton);
        add(cancelButton);
    }

   

    
}