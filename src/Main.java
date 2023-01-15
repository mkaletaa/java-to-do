//import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;


public class Main  {
    private static CardLayout card;
    private static JPanel panel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("todo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Home list = new Home();
        LoginForm form = new LoginForm();

        panel = new JPanel();
        card=new CardLayout(40,30);
        panel.setLayout(card);

        panel.add(list.getMainPanel(), "home");
        panel.add(form.getMainPanel(), "form");
        panel.setBackground(Color.RED);


        frame.add(panel);



        JMenuBar mb=new JMenuBar();
        JMenu tasks = new JMenu("Tasks");
        JMenu login = new JMenu("Log in");

        mb.add(tasks);
        mb.add(login);
        frame.setJMenuBar(mb);

        tasks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Naciśnięto menu");
                card.show(panel, "home");
            }
        });

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Naciśnięto menu");
                card.show(panel, "form");
            }
        });



        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}

//HOME:
//przycisk do logowania
//label "zalogowany/a jako: ..."
//przycisk nowego zadania
//lista zadań

//FORMULARZ LOGOWANIA:
//login
//hasło
//login do założenia konta
//hasło do założenia konta
//może coś typu email albo powtóz hasło
//może logowanie za pomocą konta google
//przycisk wyloguj

//LISTA:
//label z info o tym ile mamy zadań, ile wykonanych a ile nie
//przycisk do oznaczania jako wykonane
//przycisk do modyfikacji zadania
//przycisk do usuwania zadania
//(zadania na liście są ustawiane w ten sposób, że na samej górze są te z najwczesniejszym deadlinem, a na samym dole te już wykonane)

//NOWE ZADANIE:
//opis
//deadline, pozostały czas
//do której listy dodać*
//przycisk zatwierdzenia

