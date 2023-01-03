import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
public class Tasks {

    private final String RESET = "\u001B[0m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";

   private List<Task> tasksList = new ArrayList<>();

    public void getTasksList() {
        if(tasksList.isEmpty())
            System.out.println(RED+"Nie masz żadnych zadań na liście"+RESET);
        else{
            int i = 1;
            int undone = 0;
            System.out.println(YELLOW + "LISTA ZADAŃ:" + RESET);
            for(Task task : tasksList){
                System.out.println(i+" "+task.getContent()+" "+task.isDone());
                if(task.isDone().equals(" ")) undone++;
                i++;
            }
            System.out.print(GREEN+"Masz łącznie "+tasksList.size()+" zadań na liście"+RESET);
            System.out.print(GREEN+" z czego "+(tasksList.size()-undone)+" wykonanych i "+undone+" niewykonanych."+RESET);
            System.out.println(" ");
        }
    }

    public void setTasksList(int choice) {
        switch(choice){
            case 1 -> addTask();
            case 2 -> modifyTask();
            case 4 -> sortTasks();
            case 9 -> deleteTask();
        }
    }
    private void sortTasks(){
        Collections.sort(tasksList, new Comparator<Task>() {
            @Override
            public int compare(Task p1, Task p2) {
                return  p1.isDone().compareTo(p2.isDone());
            }
        });
    }
    private void addTask(){
        Task task1 = new Task();
        System.out.println("Wpisz swoje zadanie");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        task1.Task(content);
        this.tasksList.add(task1);
    }

    private void modifyTask(){
        if(tasksList.size()>=1) {
            System.out.println("Podaj numer zadania, które chcesz zmienić [od 1 do " + tasksList.size() + "]");
            Scanner scanner = new Scanner(System.in);
            int nr = scanner.nextInt();
            Task task = tasksList.get(nr - 1);
            String status = task.isDone();
            task.setDone(status);
            tasksList.set(nr - 1, task);
        }
        else{System.out.println(RED+"Najpierw dodaj jakieś zadanie"+RESET);}
    }

    private void deleteTask(){
        if(tasksList.size()>=1) {
            System.out.println("Podaj numer zadania, które chcesz usunąć [od 1 do " + tasksList.size() + "]");
            Scanner scanner = new Scanner(System.in);
            int nr = scanner.nextInt();
            tasksList.remove(nr - 1);
        }
        else{System.out.println(RED+"Najpierw dodaj jakieś zadanie"+RESET);}
    }
}
