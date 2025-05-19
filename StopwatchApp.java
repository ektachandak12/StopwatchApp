import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StopwatchApp {
    private JFrame frame;
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton, lapButton;
    private JTextArea lapArea;

    private Timer timer;
    private long startTime;
    private long elapsedTime = 0;
    private boolean running = false;
    private ArrayList<String> laps = new ArrayList<>();

    public StopwatchApp() {
        frame = new JFrame("Java Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        frame.add(timeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        lapButton = new JButton("Lap");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(lapButton);
        frame.add(buttonPanel, BorderLayout.CENTER);

        lapArea = new JTextArea();
        lapArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(lapArea);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Timer updates every 100 milliseconds
        timer = new Timer(100, e -> updateDisplay());

        startButton.addActionListener(e -> start());
        stopButton.addActionListener(e -> stop());
        resetButton.addActionListener(e -> reset());
        lapButton.addActionListener(e -> lap());

        frame.setVisible(true);
    }

    private void start() {
        if (!running) {
            startTime = System.currentTimeMillis() - elapsedTime;
            timer.start();
            running = true;
            updateButtonStates();
        }
    }

    private void stop() {
        if (running) {
            timer.stop();
            elapsedTime = System.currentTimeMillis() - startTime;
            running = false;
            updateButtonStates();
        }
    }

    private void reset() {
        timer.stop();
        elapsedTime = 0;
        timeLabel.setText("00:00:00");
        lapArea.setText("");
        laps.clear();
        running = false;
        updateButtonStates();
    }

    private void lap() {
        if (running) {
            long currentTime = System.currentTimeMillis();
            long time = currentTime - startTime;
            long seconds = (time / 1000) % 60;
            long minutes = (time / (1000 * 60)) % 60;
            long hours = (time / (1000 * 60 * 60));

            String timeStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            laps.add(timeStr);
            lapArea.append("Lap " + laps.size() + ": " + timeStr + "\n");
        }
    }

    private void updateDisplay() {
        long currentTime = System.currentTimeMillis();
        long time = currentTime - startTime;
        long seconds = (time / 1000) % 60;
        long minutes = (time / (1000 * 60)) % 60;
        long hours = (time / (1000 * 60 * 60));

        String timeStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(timeStr);
    }

    private void updateButtonStates() {
        startButton.setEnabled(!running);
        stopButton.setEnabled(running);
        lapButton.setEnabled(running);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StopwatchApp::new);
    }
}
