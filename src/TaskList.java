import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskList {
    private List<Task> tasks = new ArrayList<>();
    private JPanel panel;
    private JLabel delete, done;
    private JLabel info = new JLabel("Brak zadań");

    public TaskList() {
        panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel infoPanel = new JPanel();
        infoPanel.add(info);
        panel.add(infoPanel, 0);

    }

    public void setTasks(Task task) {
        this.tasks.add(task);
        setTaskPanel(task);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setTaskPanel(Task task){
//        panel.remove(empty);

                JLabel desc = new JLabel(task.getContent());
                desc.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
                JLabel delete = new JLabel("❌");
                delete.setForeground(Color.RED);
                desc.setToolTipText("wykonane / niewykonane");
                JLabel done = new JLabel("✔");
                done.setForeground(Color.GREEN);
                JPanel taskPanel = new JPanel();
                taskPanel.setBackground(Color.ORANGE);
                taskPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                taskPanel.add(desc);
                taskPanel.add(done);
                taskPanel.add(delete);
                panel.add(taskPanel);
                addInfo();
                delete.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tasks.remove(task);
                        panel.remove(taskPanel);
                        panel.revalidate();
                        panel.repaint();
//                        if(tasks.size()==0)
//                            panel.add(empty);
                        addInfo();
                    }
                });

                 done.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                         task.setDone(task.isDone());
                         if(task.isDone()==true)
                             desc.setForeground(Color.GREEN);
                         else desc.setForeground(null);
                         panel.revalidate();
                         panel.repaint();
                         addInfo();
                     }
                 });
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void addInfo(){


        int i=0;
        for(Task task:tasks){
            if(task.isDone()==true)
                i++;
        }
        info.setText("Masz na liście "+tasks.size()+" zadań, z czego "+i+" wykonanych i "+(tasks.size()-i)+" niewykonanych.");
//        info.setLineWrap(true);
//        info.setWrapStyleWord(true);
        if(tasks.size()==0)
            info.setText("Brak zadań");
    }
}
