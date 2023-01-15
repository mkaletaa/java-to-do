import javax.swing.*;

public class BoxLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // ustawienie BoxLayout w trybie PAGE_AXIS
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);

        JButton button1 = new JButton("Przycisk 1");
        JButton button2 = new JButton("Przycisk 2");
        JButton button3 = new JButton("Przycisk 3");

        panel.add(button1);
        panel.add(Box.createHorizontalStrut(5));
        panel.add(button2);
        panel.add(button3);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
