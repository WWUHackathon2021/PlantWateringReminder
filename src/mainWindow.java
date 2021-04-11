import javax.swing.*;
import java.awt.*;

public class mainWindow {

    private JFrame window;
    private JPanel dayPanel;

    public mainWindow() {
        initialize();
    }

    /* This is just a simple example of using java swing
    * maybe we can have different panels for different aspects
    * */
    private void initialize() {
        // Make a new window with different aspects
        window = new JFrame();
        window.setTitle("Main Window");
        window.setSize(400, 500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setPreferredSize(new Dimension(400, 300));

        // Add a panel
        dayPanel = new JPanel();
        dayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        dayPanel.setBackground(Color.red);

        // Add a button to the panel
        Button button = new Button("click"); // A button
        dayPanel.add(button);
        window.add(dayPanel, BorderLayout.EAST);

        // Show window
        window.setVisible(true);
    }

    public void addDays(JPanel dayPanel, JFrame window) {
        // For Loop here for
        Button button = new Button("click");
        dayPanel.add(button);
        window.add(dayPanel, BorderLayout.EAST);
    }
}
