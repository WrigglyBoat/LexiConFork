import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {
    JFrame mainFrame;
    JLabel title, centerLogo, expTrack;
    JLabel expContent, expContent1,expContent2,expContent3,expContent4;
    JPanel topPanel, sidePanel, buttonPanel, expPanel;
    JButton addButton, expButton, profile, bankLink, future1,submit; //future is future features
    JTextField date, amount, location, name; //Expense Tracking
    ImageIcon icon;
    Boolean addpanelVis = false;
    Boolean expPanelVis = false;
    String labelText, formattedDate;
    int x = 450;
    int y = 175;
    int counter = 1;
    Frame() {
        mainFrame = new JFrame();
        mainFrame.setTitle("LexiCon");
        mainFrame.setSize(1300, 800);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.getContentPane().setBackground(new Color(38, 38, 41));
        mainFrame.setLocationRelativeTo(null);
        
        //todays date vv
        LocalDate today = LocalDate.now();
        
        //Formatting the Date
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDate = today.format(format);

        //logo URL vv
        try {
            URL iconURL = new URL("https://seeklogo.com/images/L/l-letter-from-death-note-logo-6999722A33-seeklogo.com.png");
            BufferedImage logo = ImageIO.read(iconURL);
            icon = new ImageIcon(logo);
            mainFrame.setIconImage(logo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        centerLogo = new JLabel(icon);
        centerLogo.setForeground(Color.white);
        centerLogo.setBounds(500, 230, 300, 300);

        title = new JLabel("LexiCon");
        title.setBounds(15, 25, 200, 30);
        title.setFont(new Font("IMPACT", Font.BOLD, 30));
        title.setForeground(new Color(35,41,148));

        expTrack = new JLabel("Expense Tracker");
        expTrack.setBounds(575,25,300,30);
        expTrack.setFont(new Font("IMPACT", Font.BOLD, 30));
        expTrack.setForeground(Color.BLACK);
        //expTrack.setVisible(false);

        topPanel = new JPanel(null);
        topPanel.setBounds(0, 0, 1300, 80);
        topPanel.setBackground(Color.darkGray);
        topPanel.add(title);    
        topPanel.add(expTrack);

        name = new JTextField("Name");
        name.setBounds(100,20,100,20);

        date = new JTextField("Date");
        date.setBounds(250,20,100,20);

        location = new JTextField("Location");
        location.setBounds(400,20,100,20);

        amount = new JTextField("Amount");
        amount.setBounds(550, 20, 100, 20);

        //name date location amount
        submit = new JButton("Submit");
        submit.setBounds(325,55,100,25);
        submit.setBackground(new Color(35,41,148));
        submit.setForeground(Color.white);
            
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (counter < 11) {
                        savetoFile(labelText);
                        labelText = counter + ". " + name.getText() + " " +
                        date.getText() + " " + location.getText() + " " +
                        amount.getText();
                    JLabel newLabel = new JLabel(labelText);
                        newLabel.setFont(new Font("Comic Sans", Font.PLAIN, 30));
                        newLabel.setForeground(Color.white);
                        newLabel.setBounds(x,y,2000,30);
                        //newLabel.setBounds(x,y,500,30);
                        y += 50;
                        counter++;

                    mainFrame.setLayout(null);
                    mainFrame.add(newLabel);
                    
                    mainFrame.revalidate();
                    mainFrame.repaint();
                }    
            }

            private void savetoFile(String labelText) {
            }
        });

        expPanel = new JPanel(null);
        expPanel.setBounds(300,80,750,80);
        expPanel.setBackground(Color.darkGray);
        expPanel.add(date);
        expPanel.add(amount);
        expPanel.add(location);
        expPanel.add(name);
        expPanel.add(submit);
        
        //expPanel.setVisible(expPanelVis);

        sidePanel = new JPanel(null);
        sidePanel.setBounds(0, 5, 80, 800);
        sidePanel.setBackground(Color.darkGray);

        addButton = new JButton("+");
        addButton.setBounds(15, 700, 50, 50);
        addButton.setBackground(new Color(35,41,148));
        addButton.setForeground(Color.white);
        addButton.addActionListener(this);
        sidePanel.add(addButton);

        expButton = new JButton("Expense");

        expButton.addActionListener(new ActionListener() {
            //Code for expense tracking information to appear 
            public void actionPerformed(ActionEvent e) {
                if(!addpanelVis) {
                    buttonPanel.setVisible(true);
                    addpanelVis = true;
                } else {
                    buttonPanel.setVisible(false);
                    addpanelVis = false;
                }
                //Visibility Code 
            }
        });

        profile = new JButton("Profile");

        profile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!addpanelVis) {
                    buttonPanel.setVisible(true);
                    addpanelVis = true;
                } else {
                    buttonPanel.setVisible(false);
                    addpanelVis = false;
                }
            }
        });
        

        bankLink = new JButton("Link Bank"); 
        future1 = new JButton("???");

        //mainFrame will have 4 buttons one will be add expense and the rest will be question marks for the future
        buttonPanel = new JPanel();
        buttonPanel.setBounds(75, 700, 300, 80);
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setVisible(addpanelVis);
        buttonPanel.add(expButton);
        buttonPanel.add(profile);
        buttonPanel.add(bankLink);
        buttonPanel.add(future1);

        mainFrame.add(expPanel);
        mainFrame.add(buttonPanel);
        mainFrame.add(topPanel);
        mainFrame.add(sidePanel);
        mainFrame.add(centerLogo);
        mainFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!addpanelVis) {
            buttonPanel.setVisible(true);
            addpanelVis = true;
        } else {
            buttonPanel.setVisible(false);
            addpanelVis = false;
        }
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void savetoFile() {
        String fileName = formattedDate + " Expenses.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName), true))) {
            writer.write(labelText);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
