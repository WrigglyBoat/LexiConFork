import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {
    JLabel title;
    JLabel centerLogo;
    JPanel topPanel;
    JPanel sidePanel;
    JPanel buttonPanel;
    JButton addButton;
    JButton expButton;
    JButton future; //feature for the future
    JButton future1;
    JTextField text;
    ImageIcon icon;
    Boolean panelVis = false;

    Frame() {
        this.setTitle("LexiCon");
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(38, 38, 41));
        this.setLocationRelativeTo(null);

        //icon URL vv
        try {
            URL iconURL = new URL("https://seeklogo.com/images/L/l-letter-from-death-note-logo-6999722A33-seeklogo.com.png");
            BufferedImage logo = ImageIO.read(iconURL);
            icon = new ImageIcon(logo);
            this.setIconImage(logo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        centerLogo = new JLabel(icon);
        centerLogo.setForeground(Color.white);
        centerLogo.setBounds(500, 230, 300, 300);

        title = new JLabel("LexiCon");
        title.setBounds(15, 25, 200, 30);
        title.setFont(new Font("IMPACT", Font.BOLD, 30));
        title.setForeground(Color.white);

        topPanel = new JPanel(null);
        topPanel.setBounds(0, 0, 1300, 80);
        topPanel.setBackground(Color.darkGray);
        topPanel.add(title);    

        sidePanel = new JPanel(null);
        sidePanel.setBounds(0, 5, 80, 800);
        sidePanel.setBackground(Color.darkGray);

        addButton = new JButton("+");
        addButton.setBounds(15, 700, 50, 50);
        addButton.setBackground(new Color(71, 50, 66));
        addButton.setForeground(Color.white);
        addButton.addActionListener(this);
        sidePanel.add(addButton);

        expButton = new JButton("Expense");

        expButton.addActionListener(new ActionListener() {
            //Code for expense tracking information to appear 
            public void actionPerformed(ActionEvent e) {
                if(!panelVis) {
                    buttonPanel.setVisible(true);
                    panelVis = true;
                } else {
                    buttonPanel.setVisible(false);
                    panelVis = false;
                }
            }
        });

        future = new JButton("???");
        future1 = new JButton("???");

        //This will have 4 buttons one will be add expense and the rest will be question marks for the future
        buttonPanel = new JPanel();
        buttonPanel.setBounds(75, 700, 300, 80);
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setVisible(panelVis);
        buttonPanel.add(expButton);
        buttonPanel.add(future);
        buttonPanel.add(future1);

        this.add(buttonPanel);
        this.add(topPanel);
        this.add(sidePanel);
        this.add(centerLogo);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!panelVis) {
            buttonPanel.setVisible(true);
            panelVis = true;
        } else {
            buttonPanel.setVisible(false);
            panelVis = false;
        }
        this.revalidate();
        this.repaint();
    }
    
}
