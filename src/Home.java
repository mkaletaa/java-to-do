import javax.swing.*;
import java.awt.*;

public class Home {
    private JPanel homePanel;

    public Home(){

        homePanel = new JPanel();
//        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        homePanel.setBackground(Color.YELLOW);

;
        NewTask newTask = new NewTask();
        homePanel.add(newTask.getPanel());

    }

    public JPanel getMainPanel() {
        return homePanel;
    }
}
