import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    JTextArea outputArea = new JTextArea();
    boolean running = false;
    String userWord;
    JButton submit;
    JTextField input;
    GUI() {

        ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("anagram-2.png")));
        Image image2 = image.getImage();
        Image newImg = image2.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);

        JLabel description = new JLabel();
        description.setText("Let's make some anagrams");
        description.setIcon(image);
        description.setHorizontalTextPosition(JLabel.CENTER);
        description.setVerticalTextPosition(JLabel.TOP);
        description.setHorizontalAlignment(JLabel.CENTER);
        description.setVerticalAlignment(JLabel.TOP);
        description.setFont(new Font("Z003", Font.PLAIN, 30));

        input = new JTextField();
        input.setPreferredSize(new Dimension(250, 40));
        input.setFont(new Font("Impact", Font.PLAIN, 35));

        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setBounds(320, 300, 100, 50);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        titlePanel.setBounds(0, 0, 640, 212);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.white);
        inputPanel.setBounds(0, 212, 640, 50);

        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.white);
        outputPanel.setBounds(0, 262, 640, 378);

        this.setTitle("Anagram Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 640);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        titlePanel.add(description);
        inputPanel.add(input);
        inputPanel.add(submit);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.CENTER);
        this.add(outputPanel, BorderLayout.CENTER);
        outputPanel.add(outputArea);

        outputArea.setFont(new Font("Impact", Font.PLAIN, 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            running = true;
            userWord = input.getText();
        }
    }
}
