import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {
        URL logo = new URL("https://seeklogo.com/images/L/l-letter-from-death-note-logo-6999722A33-seeklogo.com.png");
        ImageIcon icon = new ImageIcon(logo, null);
        
        URL add = new URL("https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.freeiconspng.com%2Fthumbs%2Fplus-icon%2Fplus-icon-black-2.png&tbnid=yqYHdk87RNXHPM&vet=12ahUKEwiyp6KAjIWCAxU5mYQIHRPxB9wQMygAegQIARBa..i&imgrefurl=https%3A%2F%2Fwww.freeiconspng.com%2Fimages%2Fplus-icon&docid=aNO_wRhd0iQcaM&w=320&h=320&q=plus%20button%20png&client=opera-gx&ved=2ahUKEwiyp6KAjIWCAxU5mYQIHRPxB9wQMygAegQIARBa");
        ImageIcon addButt = new ImageIcon(add);

        JLabel title = new JLabel("LexiCon");
            title.setFont(new Font("IMPACT", Font.BOLD, 30));
            title.setForeground(Color.white);
            title.setBounds(15, 25, 200, 30);

        JPanel topPanel = new JPanel(null);
            topPanel.setBounds(0, 0, 1300, 80);
            topPanel.setBackground(Color.darkGray);
            topPanel.add(title);

        JPanel sidePanel = new JPanel(null);
            sidePanel.setBounds(0, 5, 80, 800);
            sidePanel.setBackground(Color.darkGray);

        JLabel centerLogo = new JLabel(null, icon, 0);
            centerLogo.setBounds(500, 230, 300, 300);
            centerLogo.setForeground(new Color(0, 0, 0, 0));

        JButton addButton = new JButton("+");
            addButton.setBounds(1200, 680, 60, 60);
            //addButton.setBounds(50, 50, 500, 500);
            addButton.setIcon(addButt);
            addButton.setBackground(new Color(70, 62, 117));
            addButton.setFont(new Font("IMPACT",Font.BOLD, 25));
            addButton.setForeground(Color.white);
    
        JFrame frame = new JFrame("LexiCon");
            frame.setIconImage(icon.getImage());
            frame.setSize(1300, 800);
            frame.setLayout(null);;
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(new Color(38,38,41));
            frame.setLocationRelativeTo(null);
            frame.add(topPanel);
            frame.add(sidePanel);
            frame.add(centerLogo);
            frame.add(addButton);
            

        frame.setVisible(true);
    }
}