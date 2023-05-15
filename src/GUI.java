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

        this.setTitle("Anagram Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 640);
        this.setResizable(false);
        this.setVisible(true);
        this.add(label);
    }

}
