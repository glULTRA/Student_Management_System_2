import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class Program 
{
    public static JFrame window = null;
    public static ArrayList<Student> students = new ArrayList<Student>();

    public static String titles[] = {"ID", "Fullname", "Address", "Mobile", "Stage", "Department"};
    static DefaultTableModel model = new DefaultTableModel(titles,0);

    public static void main(String[] args) 
    {
        // Load data
        Importer.loadData("file.txt", students);
        
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
                id.setBounds(130, 100, 50, 50);

                JTextField id_bar = new JTextField();
                id_bar = RoundBtn.desginButton(id_bar);
                id_bar.setBounds(130,150,130,60);

                // Fullname
                JLabel fullname = new JLabel("Fullname");
                fullname = RoundBtn.desginButton(fullname);
                fullname.setBounds(130, 210, 100, 50);

                JTextField fullname_bar = new JTextField();
                fullname_bar = RoundBtn.desginButton(fullname_bar);
                fullname_bar.setBounds(130,260,200,60);

                // Address
                JLabel address = new JLabel("Address");
                address = RoundBtn.desginButton(address);
                address.setBounds(130, 320, 100, 50);

                JTextField address_bar = new JTextField();
                address_bar = RoundBtn.desginButton(address_bar);
                address_bar.setBounds(130,370,200,60);

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
                JComboBox<String> stage_box = new JComboBox<>(stages);
                stage_box.setOpaque(false);
                stage_box.setFocusable(false);
                stage_box.setBackground(Color.DARK_GRAY);
                stage_box.setForeground(Color.WHITE);
                stage_box.setBounds(800, 310, 100, 30);

                // Courses!
                BufferedImage wPic = null;
                try {
                    wPic = ImageIO.read(this.getClass().getResource("wallhaven-wqve97.png"));
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                JPanel course_panel = new JPanel();
                //JLabel bgImage = new JLabel(new ImageIcon(wPic));
                course_panel.setLayout(null);
                //course_panel.add(bgImage);
                //course_panel.setBackground(Color.DARK_GRAY);
                course_panel.setBounds(800, 400, 300,370);
                course_panel.setOpaque(false);
                course_panel.setBorder(new RoundBtn(35));

                // course
                JLabel course = new JLabel("Courses");
                course = RoundBtn.desginButton(course);
                course.setBounds(100, 0, 100, 50);

                JTextField course_bar = new JTextField();
                course_bar.setBorder(new RoundBtn(15));
                course_bar.setOpaque(false);
                course_bar.setBackground(Color.BLACK);
                course_bar.setForeground(Color.WHITE);
                course_bar.setHorizontalAlignment(JTextField.CENTER);
                course_bar.setBounds(70,70,150,40);

                JButton add_course = new JButton("Add");
                add_course = RoundBtn.desginButton(add_course, 25);
                add_course.setBounds(100, 150, 100,50);

                JLabel showCourse = new JLabel();
                showCourse.setBackground(Color.BLACK);
                showCourse.setForeground(Color.white);
                showCourse.setBounds(10, 210 , 200, 100);

                
                add_course.addActionListener
                (
                    new ActionListener(){
                        int i = 0;
                        String data = "<html>";
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            if(i > 2){
                                JOptionPane.showMessageDialog(newWindow , "Sorry can't add more than 3 course!", "Maximum course added!", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            if(i == 0){
                                data += "<h4>" + (i+1) +" :" + course_bar.getText() + "</h4>";
                                showCourse.setText(data);
                                course_bar.setText("");
                            }else{
                                data =  showCourse.getText() + "<h4>" + (i+1) +" : " + course_bar.getText() +"</h4>";
                                showCourse.setText(data);
                                course_bar.setText("");
                            }
                            i += 1;
                            data += "</html>";
                        }
                    }
                );

                // Submit
                JButton submit = new JButton("Submit");
                submit.setBounds(155,590,180,70);
                submit.setBorder(new RoundBtn(25));
                submit.setOpaque(false);
                submit.setForeground(Color.WHITE);
                submit.setBackground(Color.BLACK);
                submit.setFont(new Font("Verdana", Font.BOLD, 30));
                submit.setFocusPainted(false);

                submit.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            // Submit data
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
                panel1.add(submit);
                newWindow.add(panel1);

                newWindow.setBounds(0,0, 1920,1080);
                newWindow.setVisible(true);
            }
        });

       
        studentsDataButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    // New window for data
                    JFrame newWindow = new JFrame();
                    newWindow.getContentPane().setBackground(Color.BLACK);
                    newWindow.setLayout(null);
                    newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    newWindow.setBounds(0, 0, 1920,1080);

                    // Switch student Stages!
                    JLabel stage = new JLabel("Stage");
                    stage = RoundBtn.desginButton(stage);
                    stage.setBounds(100, 100, 100, 50);


                    String stages[] = {"1", "2", "3", "4"};
                    JComboBox<String> stage_box = new JComboBox<>(stages);
                    stage_box.setOpaque(false);
                    stage_box.setFocusable(false);
                    stage_box.setBackground(Color.DARK_GRAY);
                    stage_box.setForeground(Color.WHITE);
                    stage_box.setBorder(new RoundBtn(10));
                    stage_box.setBounds(200, 100, 150, 50);

                    // Table
                    JTable table = new JTable(model);
                    table.setForeground(Color.WHITE);
                    table.setGridColor(Color.CYAN);
                    table.setBackground(Color.DARK_GRAY);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBackground(Color.BLACK);
                    scrollPane.setForeground(Color.GREEN);
                    
                    table.setFillsViewportHeight(true);
                    
                    JPanel Tpanel=new JPanel();
                    Tpanel.setBounds(100, 280, 600, 400);
                    Tpanel.setLayout(new BorderLayout());
	                Tpanel.add(scrollPane);

                    for (Student student : students) {
                        model.addRow(
                            new Object[]{
                                student.getId(),
                                student.getFullname(),
                                student.getAddress(),
                                student.getMobile(),
                                student.getStage(),
                                student.getDepartment(),
                                new JButton("Click me")
                            }
                        );
                    }

                     // Go button
                     JButton go = new JButton("Go");
                     go.setBackground(Color.BLACK);
                     go.setForeground(Color.WHITE);
                     go.setOpaque(false);
                     go.setBorder(new RoundBtn(15));
                     go.setFocusPainted(false);
                     go.setBounds(500, 100, 100, 50);
 
                     go.addActionListener(
                         new ActionListener(){
                             public void actionPerformed(ActionEvent e){
                                 // Go for new data
                             }
                         }
                     );

                    // Save button
                    JButton save = new JButton("Save");
                    save = RoundBtn.desginButton(save, 13);
                    save.setFont(new Font("Verdana", Font.PLAIN, 12));
                    save.setBounds(700,620, 100,50);

                    save.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            // Save progress
                        }
                    });

                    // Delete button
                    JButton delete = new JButton("Delete");
                    delete = RoundBtn.desginButton(delete, 13);
                    delete.setFont(new Font("Verdana", Font.PLAIN, 12));
                    delete.setBounds(700,570, 100,50);

                    delete.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            model.removeRow(table.getSelectedRow());
                        }
                    });
                    
                    newWindow.add(stage);
                    newWindow.add(stage_box);
                    newWindow.add(Tpanel);
                    newWindow.add(save);
                    newWindow.add(delete);
                    newWindow.add(go);
                    
                    newWindow.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            model.getDataVector().removeAllElements();
                        }
                    });

                    newWindow.setVisible(true);
                }
            }
        );
        

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