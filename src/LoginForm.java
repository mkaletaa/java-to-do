import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    private JTextField passwordField;
    private JPanel mainPanel;

    public LoginForm(){
        passwordField = new JTextField("wwww");
        mainPanel = new JPanel();
        mainPanel.add(passwordField);

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
