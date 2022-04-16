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
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

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
        panel1.setBounds(5,5,1920,1080);

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
                newWindow.getContentPane().setBackground(Color.BLACK);

                JPanel panel1 = new JPanel();
                panel1.setBounds(0, 0, 1920, 1080);
                panel1.setBackground(Color.BLACK);
                panel1.setLayout(null);

                JLabel title = new JLabel("Adding a new student :");
                title.setForeground(Color.white);
                title.setBounds(5, 5, 500,100);
                title.setFont(new Font("Verdana", Font.BOLD, 25));

                // Input forms
                // ID
                JLabel id = new JLabel("ID");
                id = RoundBtn.desginButton(id);
                id.setBounds(20, 100, 50, 50);

                JTextField id_bar = new JTextField();
                id_bar = RoundBtn.desginButton(id_bar);
                id_bar.setBounds(20,150,130,60);

                // Fullname
                JLabel fullname = new JLabel("Fullname");
                fullname = RoundBtn.desginButton(fullname);
                fullname.setBounds(20, 210, 100, 50);

                JTextField fullname_bar = new JTextField();
                fullname_bar = RoundBtn.desginButton(fullname_bar);
                fullname_bar.setBounds(20,260,200,60);

                // Address
                JLabel address = new JLabel("Address");
                address = RoundBtn.desginButton(address);
                address.setBounds(20, 320, 100, 50);

                JTextField address_bar = new JTextField();
                address_bar = RoundBtn.desginButton(address_bar);
                address_bar.setBounds(20,370,200,60);

                // Mobile
                JLabel mobile = new JLabel("Mobile");
                mobile = RoundBtn.desginButton(mobile);
                mobile.setBounds(800, 100, 100, 50);

                JTextField mobile_bar = new JTextField();
                mobile_bar = RoundBtn.desginButton(mobile_bar);
                mobile_bar.setBounds(800,150,200,60);

                // Stage
                JLabel stage = new JLabel("Stage");
                stage = RoundBtn.desginButton(stage);
                stage.setBounds(800, 250, 100, 50);

                String stages[] = {"1", "2", "3", "4"};
                JComboBox stage_box = new JComboBox(stages);
                stage_box.setOpaque(false);
                stage_box.setFocusable(false);
                stage_box.setBackground(Color.DARK_GRAY);
                stage_box.setForeground(Color.WHITE);
                stage_box.setBounds(800, 310, 100, 30);

                // Courses!
                JPanel course_panel = new JPanel();
                course_panel.setLayout(null);
                //course_panel.setBackground(Color.DARK_GRAY);
                course_panel.setBounds(750, 400, 300,400);
                course_panel.setOpaque(false);
                course_panel.setBorder(new RoundBtn(35));

                // course
                JLabel course = new JLabel("Courses");
                course = RoundBtn.desginButton(course);
                course.setBounds(100, 0, 100, 50);

                JTextField course_bar = new JTextField();
                //course_bar = RoundBtn.desginButton(course_bar);
                course_bar.setOpaque(false);
                course_bar.setBackground(Color.BLACK);
                course_bar.setForeground(Color.WHITE);
                course_bar.setBounds(70,70,150,60);

                JButton add_course = new JButton("Add");
                add_course = RoundBtn.desginButton(add_course, 25);
                add_course.setBounds(100, 150, 100,50);

                JLabel showCourse = new JLabel();
                //showCourse = RoundBtn.desginButton(showCourse);
                showCourse.setBackground(Color.BLACK);
                showCourse.setForeground(Color.white);
                showCourse.setBounds(10, 200 , 300, 100);

                
                add_course.addActionListener
                (
                    new ActionListener(){
                        int i = 0;
                        String data = "<html>";
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            if(i > 2) return;
                            if(i == 0){
                                data += "<h4>" + (i+1) +" :" + course_bar.getText() + "</h4>";
                                showCourse.setText(data);
                            }else{
                                data =  showCourse.getText() + "<h4>" + (i+1) +" : " + course_bar.getText() +"</h4>";
                                showCourse.setText(data);
                            }
                            i += 1;
                            data += "</html>";
                        }
                    }
                );

                course_panel.add(course);
                course_panel.add(course_bar);
                course_panel.add(add_course);
                course_panel.add(showCourse);
                
        
                panel1.add(id);
                panel1.add(id_bar);
                panel1.add(fullname);
                panel1.add(fullname_bar);
                panel1.add(address);
                panel1.add(address_bar);
                panel1.add(mobile);
                panel1.add(mobile_bar);
                panel1.add(title);
                panel1.add(stage);
                panel1.add(stage_box);
                panel1.add(course_panel);
                newWindow.add(panel1);

                newWindow.setBounds(0,0, 1920,1080);
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

    public static JLabel desginButton(JLabel lbl)
    {
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("Verdana", Font.BOLD, 15));
        return lbl;
    }

    public static JTextField desginButton(JTextField txtFld)
    {
        txtFld.setBackground(Color.WHITE);
        txtFld.setForeground(Color.WHITE);
        txtFld.setOpaque(false);
        txtFld.setBorder(new RoundBtn(20));
        return txtFld;
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