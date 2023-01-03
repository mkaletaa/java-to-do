import java.awt.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;


public class Main {
    public Main(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 10, 100));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
        final String RESET = "\u001B[0m";
        final String YELLOW = "\u001B[33m";

        Scanner scanner = new Scanner(System.in);

        boolean shouldContinue = true;

        Tasks taskList = new Tasks();

        while (shouldContinue) {
            taskList.getTasksList();

            System.out.println(YELLOW+"MENU"+RESET);
            System.out.println("1 dodaj zadanie");
            System.out.println("2 zmień status (wykonane/niewykonane)");
            System.out.println("3 zobacz listę zadań");
            System.out.println("9 usuń zadanie");
            System.out.println("0 Wyłącz program");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> taskList.setTasksList(choice);
                case 2 -> taskList.setTasksList(choice);
                case 3 -> taskList.getTasksList();
                case 9 -> taskList.setTasksList(choice);
                case 0 -> shouldContinue = false;
            }
        }
    }
}

//iterator, Date object, sortowanie, wiele list może