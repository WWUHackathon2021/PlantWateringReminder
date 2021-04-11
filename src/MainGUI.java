import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MainGUI extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel upcomingRemindersPanel;
    private JPanel myRemindersPanel;
    private JScrollPane myPlantsScrollPane;
    private JTable myPlantsTable;
    private JScrollPane upcomingScrollPane;
    private JTable upcomingRemindersTable;
    private JButton addPlantButton;
    private JButton removePlantButton;
    private JButton saveDataButton;
    private JButton loadDataButton;
    private JPanel buttonPanel;
    private JLabel leafLabel;
    private DefaultTableModel tableModel;
    private ReminderCalendar remCal;

    public MainGUI() {
        super("Plant Watering Reminder");
        ImageIcon icon = new ImageIcon("assets/Leaf.png");
        leafLabel.setIcon(icon);
        remCal = new ReminderCalendar();
        remCal.setLength(50);
        remCal.loadData();
        updateAll();
        this.setSize(500, 500);
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myPlantsTable.setDefaultEditor(Object.class, null);
        upcomingRemindersTable.setDefaultEditor(Object.class, null);
        buttonPanel.setMaximumSize(new Dimension(125, -1));
        setVisible(true);
        addPlantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plantName = JOptionPane.showInputDialog("Enter name of plant:");
                String plantType = JOptionPane.showInputDialog("Enter type of plant:");
                String plantInterval = JOptionPane.showInputDialog("How many days between watering this plant?");
                String plantOffset = JOptionPane.showInputDialog("How many days ago did you water this plant? (0 for today)");
                int intervalInt = Integer.parseInt(plantInterval);
                int offsetInt = Integer.parseInt(plantOffset);
                remCal.addReminder(new Plant(plantName, plantType, intervalInt, offsetInt, 0));
                updateAll();
            }
        });
        removePlantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String removeID = JOptionPane.showInputDialog("Enter ID of plant (-1 to cancel):");
                int removeInt = Integer.parseInt(removeID);
                remCal.removeReminder(removeInt);
                updateAll();
            }
        });
        saveDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remCal.saveData();
            }
        });
        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remCal.loadData();
                updateAll();
            }
        });
    }

    public void updateAll() {
        remCal.updateDays();
        updateReminders(remCal.getDays());
        updatePlantData(remCal.getReminders());
    }

    public void updatePlantData(ArrayList<Reminder> reminderData) {
        String[][] data = new String[reminderData.size()][6];
        GregorianCalendar today;
        for (int i = 0; i < reminderData.size(); i++) {
            today = remCal.getToday();
            data[i][0] = reminderData.get(i).getNameString();
            data[i][1] = reminderData.get(i).getType();
            data[i][2] = reminderData.get(i).getDaysBetween() + " Days";
            today.add(GregorianCalendar.DAY_OF_YEAR, -1 * reminderData.get(i).getOffset());
            data[i][3] = (today.get(GregorianCalendar.MONTH) + 1) + "/" + today.get(GregorianCalendar.DAY_OF_MONTH) + "/" + today.get(GregorianCalendar.YEAR);
            today.add(GregorianCalendar.DAY_OF_YEAR, reminderData.get(i).getDaysBetween());
            data[i][4] = (today.get(GregorianCalendar.MONTH) + 1) + "/" + today.get(GregorianCalendar.DAY_OF_MONTH) + "/" + today.get(GregorianCalendar.YEAR);
            data[i][5] = "" + i;
        }
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Type");
        tableModel.addColumn("Interval");
        tableModel.addColumn("Last");
        tableModel.addColumn("Next");
        tableModel.addColumn("ID");
        for (int i = 0; i < data.length; i++) {
            tableModel.insertRow(i, data[i]);
        }
        myPlantsTable.setModel(tableModel);
        myPlantsTable.getColumnModel().getColumn(2).setMaxWidth(65);
        myPlantsTable.getColumnModel().getColumn(3).setMaxWidth(65);
        myPlantsTable.getColumnModel().getColumn(4).setMaxWidth(65);
        myPlantsTable.getColumnModel().getColumn(5).setMaxWidth(20);
    }

    public void updateReminders(String[][] days) {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Date");
        tableModel.addColumn("Tasks");
        for (int i = 0; i < days.length; i++) {
            tableModel.insertRow(i, days[i]);
        }
        upcomingRemindersTable.setModel(tableModel);
        upcomingRemindersTable.getColumnModel().getColumn(0).setMaxWidth(65);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        tabbedPane = new JTabbedPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(tabbedPane, gbc);
        upcomingRemindersPanel = new JPanel();
        upcomingRemindersPanel.setLayout(new GridBagLayout());
        tabbedPane.addTab("Upcoming Waterings", upcomingRemindersPanel);
        upcomingScrollPane = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        upcomingRemindersPanel.add(upcomingScrollPane, gbc);
        upcomingRemindersTable = new JTable();
        upcomingRemindersTable.setAutoCreateRowSorter(false);
        upcomingScrollPane.setViewportView(upcomingRemindersTable);
        myRemindersPanel = new JPanel();
        myRemindersPanel.setLayout(new GridBagLayout());
        tabbedPane.addTab("My Plants", myRemindersPanel);
        myPlantsScrollPane = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        myRemindersPanel.add(myPlantsScrollPane, gbc);
        myPlantsTable = new JTable();
        myPlantsScrollPane.setViewportView(myPlantsTable);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(buttonPanel, gbc);
        addPlantButton = new JButton();
        addPlantButton.setText("Add Plant");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(addPlantButton, gbc);
        removePlantButton = new JButton();
        removePlantButton.setText("Remove Plant");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(removePlantButton, gbc);
        saveDataButton = new JButton();
        saveDataButton.setText("Save Data");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(saveDataButton, gbc);
        loadDataButton = new JButton();
        loadDataButton.setText("Load Data");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(loadDataButton, gbc);
        leafLabel = new JLabel();
        leafLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(leafLabel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
