import javax.swing.*;
import java.awt.*;

public class ErrorFrame extends JComponent{

    private int width = 500;
    private int height = 100;

    public ErrorFrame(String errorText){
        JFrame errorF = new JFrame();
        JPanel errorPanel = new JPanel();
        errorF.setSize(width, height);
        JButton closeButton = new JButton("OK");
        JLabel errorTextLabel = new JLabel(errorText);
        errorF.add(errorPanel);

        errorPanel.add(errorTextLabel);
        errorPanel.add(closeButton, BorderLayout.SOUTH);
        closeButton.addActionListener(a->ConfirmButtonPressed(errorF));
        errorF.setVisible(true);
    }


    void ConfirmButtonPressed(JFrame frame){
        frame.setVisible(false);
    }
}
