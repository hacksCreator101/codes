import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlyFeatureApp {
    // Player position variables
    private double playerX = 0;
    private double playerY = 0;
    private double playerZ = 0;
    private boolean isFlying = false;

    // Main method to launch the app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlyFeatureApp app = new FlyFeatureApp();
            app.createAndShowGUI();
        });
    }

    // Method to create and display the UI
    private void createAndShowGUI() {
        // Frame
        JFrame frame = new JFrame("Fly Feature Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Panel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Make frame visible
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null); // Use null layout for custom placement

        // Title Label
        JLabel titleLabel = new JLabel("Fly Feature Controls");
        titleLabel.setBounds(120, 10, 200, 25);
        panel.add(titleLabel);

        // Position Label
        JLabel positionLabel = new JLabel("Position: X=0, Y=0, Z=0");
        positionLabel.setBounds(20, 50, 300, 25);
        panel.add(positionLabel);

        // Flying Status Label
        JLabel flyingLabel = new JLabel("Flying Mode: Disabled");
        flyingLabel.setBounds(20, 80, 300, 25);
        panel.add(flyingLabel);

        // Buttons
        JButton flyToggleButton = new JButton("Toggle Fly Mode");
        flyToggleButton.setBounds(20, 120, 150, 25);
        panel.add(flyToggleButton);

        JButton upButton = new JButton("Move Up");
        upButton.setBounds(180, 120, 100, 25);
        panel.add(upButton);

        JButton downButton = new JButton("Move Down");
        downButton.setBounds(290, 120, 100, 25);
        panel.add(downButton);

        JButton runButton = new JButton("Run Script");
        runButton.setBounds(20, 160, 150, 25);
        panel.add(runButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(290, 160, 100, 25);
        panel.add(exitButton);

        // Button Action Listeners
        flyToggleButton.addActionListener(e -> {
            isFlying = !isFlying;
            flyingLabel.setText("Flying Mode: " + (isFlying ? "Enabled" : "Disabled"));
        });

        upButton.addActionListener(e -> {
            if (isFlying) {
                playerY += 1;
                positionLabel.setText(String.format("Position: X=%.1f, Y=%.1f, Z=%.1f", playerX, playerY, playerZ));
            } else {
                JOptionPane.showMessageDialog(panel, "Enable flying mode first!");
            }
        });

        downButton.addActionListener(e -> {
            if (isFlying) {
                playerY = Math.max(0, playerY - 1); // Prevent negative height
                positionLabel.setText(String.format("Position: X=%.1f, Y=%.1f, Z=%.1f", playerX, playerY, playerZ));
            } else {
                JOptionPane.showMessageDialog(panel, "Enable flying mode first!");
            }
        });

        runButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Running the script...");
            // Here you could call or integrate your script logic
            System.out.println("Script executed! Player is at X=" + playerX + ", Y=" + playerY + ", Z=" + playerZ);
        });

        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Exiting Fly Feature Application...");
            System.exit(0);
        });
    }
}
