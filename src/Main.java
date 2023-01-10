import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        // Tworzenie kontenera z trzema przyciskami
        JPanel cards = new JPanel();
        JButton button1 = new JButton("Przycisk 1");
        JButton button2 = new JButton("Przycisk 2");
        JButton button3 = new JButton("Przycisk 3");

        // Ustawienie CardLayout jako menedżera rozkładu kontenera
        CardLayout cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        // Dodanie przycisków do kontenera i oznaczenie ich jako karty
        cards.add(button1, "Karta 1");
        cards.add(button2, "Karta 2");
        cards.add(button3, "Karta 3");

        // Ustawienie pierwszej karty jako widocznej
        cardLayout.show(cards, "Karta 1");

        // Dodanie kontenera z przyciskami do okna
        add(cards);
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("CardLayout Example");
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
