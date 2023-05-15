import javax.swing.*;

public class GUI extends JFrame {

    GUI() {

        ImageIcon image = new ImageIcon("anagram-2.png");

        JLabel label = new JLabel();
        label.setText("Let's make some anagrams");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);

        this.setTitle("Anagram Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 640);
        this.setResizable(false);
        this.setVisible(true);
        this.add(label);
    }

}
