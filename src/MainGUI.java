import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel upcomingRemindersPanel;
    private JPanel myRemindersPanel;
    private JScrollPane myPlantsScrollPane;
    private JTable myPlantsTable;
    private JScrollPane upcomingScrollPane;
    private JTable upcomingRemindersTable;
    private DefaultTableModel tableModel;

    public MainGUI(){
        super("Plant Watering Reminder");
        this.setSize(500, 500);
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myPlantsTable.setDefaultEditor(Object.class, null);
        upcomingRemindersTable.setDefaultEditor(Object.class, null);
        setVisible(true);
    }

    public void updatePlantData(String[][] data){
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Type");
        tableModel.addColumn("Watering Interval");
        tableModel.addColumn("Last Watered");
        tableModel.addColumn("Next Watering");
        for(int i = 0; i < data.length; i++){
            tableModel.insertRow(i, data[i]);
        }
        myPlantsTable.setModel(tableModel);
    }

    public void updateReminders(String[][] days){
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Date");
        tableModel.addColumn("Tasks");
        for(int i = 0; i < days.length; i++){
            tableModel.insertRow(i, days[i]);
        }
        upcomingRemindersTable.setModel(tableModel);
        upcomingRemindersTable.getColumnModel().getColumn(0).setMaxWidth(30);
    }

}
