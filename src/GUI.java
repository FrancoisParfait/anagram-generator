import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    GUI() {

        ImageIcon image = new ImageIcon("anagram-2.png");
        Image image2 = image.getImage();
        Image newImg = image2.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);

        JLabel label = new JLabel();
        label.setText("Let's make some anagrams");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(new Font("Z003", Font.PLAIN, 30));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        titlePanel.setBounds(0, 0, 640, 212);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.red);
        inputPanel.setBounds(0, 212, 640, 428);

        this.setTitle("Anagram Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 640);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        titlePanel.add(label);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.CENTER);
    }

}
