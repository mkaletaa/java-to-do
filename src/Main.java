import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
            System.out.println("4 posortuj");
            System.out.println("9 usuń zadanie");
            System.out.println("0 Wyłącz program");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> taskList.setTasksList(choice);
                case 2 -> taskList.setTasksList(choice);
                case 3 -> taskList.getTasksList();
                case 4 -> taskList.setTasksList(choice);
                case 9 -> taskList.setTasksList(choice);
                case 0 -> shouldContinue = false;
            }
        }
    }
}
