import javax.swing.*;
import java.awt.*;

public class NewTask {
    private JTextField description;
    private JButton newTask, addTask, cancelBtn;
    private JPanel panel, btnPanel, detailsPanel;
    //lista do której dodane zostanie zadanie
    private TaskList taskList = new TaskList();
    public NewTask() {
        description = new JTextField();
        description.setPreferredSize(new Dimension(120, 30));
        newTask = new JButton("stwórz nowe zadanie");
        addTask = new JButton("dodaj");
        cancelBtn = new JButton("anuluj");
        btnPanel = new JPanel();
        btnPanel.add(newTask);

        detailsPanel = new JPanel();
        detailsPanel.setBackground(Color.BLUE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        detailsPanel.setLayout(gridBagLayout);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        detailsPanel.add(description, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        detailsPanel.add(addTask, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        detailsPanel.add(cancelBtn, constraints);

//        detailsPanel.add(description);
//        detailsPanel.add(addTask);
//        detailsPanel.add(cancelBtn);

        taskList = new TaskList();

        panel = new JPanel();
//        GridBagConstraints panelConstraints = new GridBagConstraints();
//        panelConstraints.weightx = 1.0;
//        panelConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.GREEN);

//        panelConstraints.gridx = 0;
//        panelConstraints.gridy = 0;
        panel.add(btnPanel);
        panel.add(detailsPanel);
//        panelConstraints.gridx = 0;
//        panelConstraints.gridy = 2;
        panel.add(taskList.getPanel());
//        panel.setSize(new Dimension(550, -1));

        //by default details are hidden
        setVisibility();
        newTask.addActionListener(e->{
            setVisibility();
        });
        cancelBtn.addActionListener(e->{
            setVisibility();
        });
        addTask.addActionListener(e->{
            if(!description.getText().isBlank()) {
                setVisibility();
                submit(description.getText());
            }
        });

    }

    private void setVisibility(){
        if (detailsPanel.isVisible()) {
            detailsPanel.setVisible(false);
            btnPanel.setVisible(true);
            newTask.setText("stwórz nowe zadanie");
        } else {
            detailsPanel.setVisible(true);
            btnPanel.setVisible(false);
            newTask.setText("anuluj");
        }
    }

    private void submit(String content){
            description.setText("");
            detailsPanel.setVisible(false);
            newTask.setText("stwórz nowe zadanie");
            Task task = new Task(content);
            taskList.setTasks(task);

//            if(taskList.getTasks().size()==1){
//                taskList.addInfo();
//            }
    }

    public JPanel getPanel() {
        return panel;
    }
}
