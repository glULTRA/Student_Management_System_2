import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Program 
{
    public static JFrame window;
    public ArrayList<Student> students;
    public static void main(String[] args) 
    {
        // Creating Window
        window = new JFrame("Student Management System");
        window.setBounds(0, 0, 1920,1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.getContentPane().setBackground(Color.BLACK);


        // Home
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.setLayout(null);
        panel1.setBounds(5,5,1080,1920);

        JLabel title = new JLabel("Student Management System");
        title.setForeground(Color.white);
        title.setBounds(560, 5, 500,100);
        title.setFont(new Font("Verdana", Font.BOLD, 25));
        
        // buttons
        JButton registerButton = new JButton("Register a new student");
        registerButton.setBounds(610,350,300,50);
        registerButton = RoundBtn.desginButton(registerButton, 25);


        JButton studentsDataButton = new JButton("Students Data");
        studentsDataButton.setBounds(610,500,300,50);
        studentsDataButton = RoundBtn.desginButton(studentsDataButton, 25);



        registerButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creating new window for inputing data.
                JFrame newWindow = new JFrame("Entering data!");
                newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newWindow.setLayout(null);


                newWindow.setBounds(400,100, 400,400);
                newWindow.setVisible(true);
            }
        });

       // JButton 
        

        panel1.add(title);
        panel1.add(studentsDataButton);
        panel1.add(registerButton);
        
        window.add(panel1);

        window.setVisible(true);
    }
}


class RoundBtn implements Border 
{
    private int r;
    RoundBtn(int r) {
        this.r = r;
    }
    public static JButton desginButton(JButton btn, int radius)
    {
        btn.setFont(new Font("Verdana", Font.BOLD, 18));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.white);
        btn.setOpaque(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(true);
        btn.setBorder(new RoundBtn(radius));

        return btn;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, 
    int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}