import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class Program implements ChangeListener
{
    public static JFrame window = null;
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static final String file = "file.txt";
    public static final String course_file = "course.txt";

    public static String titles[] = {"ID", "Fullname", "Address", "Mobile", "Stage"};
    static DefaultTableModel model = new DefaultTableModel(titles,0);

    static JButton registerButton = new JButton("Register a new student");
    static JButton studentsDataButton = new JButton("Students Data");

    public static void addToModel(Student student, DefaultTableModel model){
        model.addRow(
            new Object[]{
                student.getId(),
                student.getFullname(),
                student.getAddress(),
                student.getMobile(),
                student.getStage(),
                student.getDepartment(),
            }
        );
    }

    public static void main(String[] args) 
    {
        // Load data
        Importer.loadData(file, course_file, students);
        
        // Creating Window
        window = new JFrame("Student Management System");
        window.setBounds(0, 0, 1920,1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.getContentPane().setBackground(Color.WHITE);


        // Home
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(null);
        panel1.setBounds(5,5,1920,1080);

        JLabel title = new JLabel("Student Management System");
        title.setForeground(Color.white);
        title.setBounds(560, 5, 500,100);
        title.setFont(new Font("Verdana", Font.BOLD, 25));
        
        // buttons
        registerButton.setBounds(610,350,300,50);
        RoundBtn.desginButton(registerButton, 10);

        studentsDataButton.setBounds(610,500,300,50);
        RoundBtn.desginButton(studentsDataButton, 10);

        registerButton.addChangeListener(new Program());
        studentsDataButton.addChangeListener(new Program());

        registerButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creating new window for inputing data.
                JFrame newWindow = new JFrame("Entering data!");
                newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newWindow.setLayout(null);
                newWindow.getContentPane().setBackground(Color.WHITE);

                JPanel panel1 = new JPanel();
                panel1.setBounds(0, 0, 1920, 1080);
                panel1.setBackground(Color.WHITE);
                panel1.setLayout(null);
                

                JLabel title = new JLabel("<html><h1>Adding a new student :</h1></html>");
                title.setBounds(15, 5, 500,100);
                title.setFont(new Font("Verdana", Font.BOLD, 25));

                // Input forms
                // ID
                JLabel id = new JLabel("<html><h2 style=\"color:#0275d8\">ID</h2></html>");
                RoundBtn.desginButton(id);
                id.setBounds(130, 100, 50, 50);

                JTextField id_bar = new JTextField();
                RoundBtn.desginButton(id_bar);
                id_bar.setBounds(130,150,130,60);
                id_bar.setPreferredSize(new Dimension(80,20));

                // Fullname
                JLabel fullname = new JLabel("<html><h2  style=\"color:#0275d8\">Fullname</h2></html>");
                RoundBtn.desginButton(fullname);
                fullname.setBounds(130, 210, 130, 50);

                JTextField fullname_bar = new JTextField();
                RoundBtn.desginButton(fullname_bar);
                fullname_bar.setBounds(130,260,200,60);

                // Address
                JLabel address = new JLabel("<html><h2  style=\"color:#0275d8\"> Address</h2></html>");
                RoundBtn.desginButton(address);
                address.setBounds(130, 320, 100, 50);

                JTextField address_bar = new JTextField();
                RoundBtn.desginButton(address_bar);
                address_bar.setBounds(130,370,200,60);

                // Mobile
                JLabel mobile = new JLabel("<html><h2 style=\"color:#0275d8\">Phone Number</h2></html>");
                RoundBtn.desginButton(mobile);
                mobile.setBounds(800, 100, 140, 50);

                JTextField mobile_bar = new JTextField();
                RoundBtn.desginButton(mobile_bar);
                mobile_bar.setBounds(800,150,200,60);

                // Stage
                JLabel stage = new JLabel("<html><h2 style=\"background: linear-gradient(to bottom, #33ccff 0%, #ff99cc 100%);\">Stage</h2></html>");
                RoundBtn.desginButton(stage);
                stage.setBounds(800, 220, 100, 50);

                String stages[] = {"1", "2", "3", "4"};
                JComboBox<String> stage_box = new JComboBox<>(stages);
                stage_box.setOpaque(false);
                stage_box.setFocusable(false);
                stage_box.setBackground(new Color(2, 117, 216));
                stage_box.setForeground(Color.WHITE);
                //stage_box.setBorder(new LineBorder( new Color(30,45,65), 3));
                stage_box.setBounds(800, 280, 150, 30);

                // Courses!
                JPanel course_panel = new JPanel();//{
                //    @Override
                //    protected void paintComponent(Graphics grphcs) {
                //        super.paintComponent(grphcs);
                //        Graphics2D g2d = (Graphics2D) grphcs;
                //        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                //                RenderingHints.VALUE_ANTIALIAS_ON);
                //        GradientPaint gp = new GradientPaint(0, 0,
                //                getBackground().brighter().brighter(), 255, getHeight(),
                //                getBackground().darker().darker());
                //        g2d.setPaint(gp);
                //        g2d.fillRect(0, 0, getWidth(), getHeight()); 
//
                //    }
                //};
                course_panel.setLayout(null);
                course_panel.setBackground(new Color(67, 145, 155));
                course_panel.setBounds(800, 400, 300,370);
                course_panel.setBorder(new RoundBtn(19));

                // course
                JLabel course = new JLabel("Courses");
                RoundBtn.desginButton(course);
                course.setBounds(100, 0, 100, 50);

                JTextField course_bar = new JTextField("new courses..");
                RoundBtn.desginButton(course_bar);
                course_bar.setOpaque(true);
                course_bar.setBackground(new Color(48, 170, 221));
                course_bar.setHorizontalAlignment(JTextField.CENTER);
                course_bar.setBounds(70,70,150,60);

                JButton add_course = new JButton("+  Add");
                RoundBtn.desginButton(add_course, 10);
                add_course.setOpaque(true);
                add_course.setBackground(new Color(48, 170, 221));
                add_course.setBounds(85, 150, 120,50);

                JButton clear_course = new JButton("- Clear");
                RoundBtn.desginButton(clear_course, 10);
                clear_course.setOpaque(true);
                clear_course.setBackground(new Color(217, 83, 79));
                clear_course.setBounds(190, 310, 100,50);
                clear_course.setVisible(false);

                JLabel showCourse = new JLabel();
                showCourse.setBounds(50, 210 , 300, 100);

                add_course.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e){
                        JButton btn = add_course;
                        if (btn.getModel().isPressed()) {
                            btn.setOpaque(true);
                            btn.setBackground(new Color(0,191,255));
                            
                        } 
                        else if (btn.getModel().isRollover()) {
                            btn.setOpaque(true);
                            btn.setBackground(new Color(30,144,255));
                        } 
                        else {
                            RoundBtn.desginButton(btn, 10);
                            btn.setOpaque(true);
                            btn.setBackground(new Color(48, 170, 221));
                        }
                    }
                });

                clear_course.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e){
                        JButton btn = clear_course;
                        if (btn.getModel().isPressed()) {
                            btn.setOpaque(true);
                            btn.setBackground(new Color(255,105,180));
                        } 
                        else if (btn.getModel().isRollover()) {
                            btn.setOpaque(true);
                            btn.setBackground(new Color(255,20,147));
                        } 
                        else {
                            btn.setBackground(new Color(217, 83, 79));
                        }
                    }
                });

                String courses[] = {"none", "none", "none"};

                add_course.addActionListener
                (
                    new ActionListener()
                    {
                        String data = "<html>";
                        int i = 0;

                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            if (!course_bar.getText().isEmpty())
                            {
                                clear_course.setVisible(true);
                                if(i > 2){
                                    JOptionPane.showMessageDialog(newWindow , "Sorry can't add more than 3 course!", "Maximum course added!", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                                if(i == 0){
                                    courses[i] = course_bar.getText();
                                    data += "<h4>" + "Course " + (i+1) +" :" + course_bar.getText().toString() + "</h4>";
                                    showCourse.setText(data);
                                    course_bar.setText("");
                                }else{
                                    courses[i] = course_bar.getText();
                                    data =  showCourse.getText() + "<h4>" + "Course " + (i+1) +" : " + course_bar.getText().toString() +"</h4>";
                                    showCourse.setText(data);
                                    course_bar.setText("");
                                }
                                i += 1;
                                data += "</html>";
                                clear_course.addActionListener(
                                    new ActionListener() 
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            showCourse.setText("");
                                            data = "<html>";
                                            i=0;
                                            clear_course.setVisible(false);
                                        }
                                    }
                                );
                            }
                        }
                    }
                );

                

                // Submit
                JButton submit = new JButton("Submit");
                submit.setBounds(155,590,180,70);
                RoundBtn.desginButton(submit, 10);
                submit.setOpaque(true);
                submit.setBackground(new Color(50,205,50));

                submit.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e){
                        JButton btn = submit;
                        if (btn.getModel().isPressed()) {
                            btn.setOpaque(true);
                            btn.setBackground(new Color(0,255,0));
                            
                        } 
                        else if (btn.getModel().isRollover()) {
                            btn.setOpaque(true);
                            btn.setBackground(new Color(152,251,152));
                        } 
                        else {
                            btn.setBackground(new Color(50,205,50));
                        }
                    }
                });

                submit.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            // Submit data
                            try {
                                Student student = new Student();
                                student.setId(Integer.parseInt(id_bar.getText()));

                                student.setFullname(fullname_bar.getText());
                                student.setAddress(address_bar.getText());
                                student.setMobile(mobile_bar.getText());
                                student.setStage(stage_box.getSelectedIndex()+1);

                                student.setCourse1(courses[0]);
                                student.setCourse2(courses[1]);
                                student.setCourse3(courses[2]);

                                
                                if(!Student.isIdAvailable(students, student.getId())){
                                    JOptionPane.showMessageDialog(newWindow, "ID is already exist !", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                else if(student.getFullname().isEmpty() || student.getAddress().isEmpty() || student.getMobile().isEmpty()){
                                        JOptionPane.showMessageDialog(newWindow, "please fill all informations!", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                                else{
                                    students.add(student);
                                    Student.updateData(file, students);
                                    Course.updateData(course_file, students);
                                    JOptionPane.showMessageDialog(newWindow, "Added new student Successfuly !");
                                    id_bar.setText("0");
                                    newWindow.dispose();
                                }
                            } catch (Exception e2) {
                                JOptionPane.showMessageDialog(newWindow, "please make sure id is number!", "Warning", JOptionPane.WARNING_MESSAGE);

                            }
                        }
                    }
                );


                course_panel.add(course);
                course_panel.add(course_bar);
                course_panel.add(add_course);
                course_panel.add(clear_course);
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
                    newWindow.getContentPane().setBackground(Color.WHITE);
                    newWindow.setLayout(null);
                    newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    newWindow.setBounds(0, 0, 1920,1080);

                    // Switch student Stages!
                    JLabel stage = new JLabel("Stage");
                    RoundBtn.desginButton(stage);
                    stage.setBounds(100, 100, 100, 50);


                    String stages[] = {"1", "2", "3", "4", "All Stage"};
                    JComboBox<String> stage_box = new JComboBox<>(stages);
                    stage_box.setOpaque(false);
                    stage_box.setFocusable(false);
                    stage_box.setBackground(new Color(70,130,180));
                    stage_box.setForeground(Color.WHITE);
                    stage_box.setBorder(new RoundBtn(10));
                    stage_box.setBounds(200, 100, 150, 50);
                    stage_box.setSelectedIndex(4);

                    // Table
                    JTable table = new JTable(model);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBackground(Color.BLACK);
                    scrollPane.setForeground(Color.GREEN);
                    
                    table.setFillsViewportHeight(true);
                    
                    JPanel Tpanel=new JPanel();
                    Tpanel.setBounds(100, 310, 600, 400);
                    Tpanel.setLayout(new BorderLayout());
	                Tpanel.add(scrollPane);

                    for (Student student : students) {
                        addToModel(student, model);
                    }
                    

                    // Go button
                    JButton go = new JButton("Go");
                    RoundBtn.desginButton(go, 10);
                    go.setOpaque(true);
                    go.setBackground(new Color(70,130,180));
                    go.setBounds(400, 100, 100, 50);
                    
                    
                    // Search 
                    JButton search = new JButton("Search");
                    RoundBtn.desginButton(search, 10);
                    search.setOpaque(true);
                    search.setBackground(new Color(50,205,50));
                    search.addChangeListener(new Program());
                    search.setBounds(400, 200, 100, 50);

                    search.addChangeListener(new ChangeListener() {
                        public void stateChanged(ChangeEvent e){
                            JButton btn = search ;
                            if (btn.getModel().isPressed()) {
                                btn.setOpaque(true);
                                btn.setBackground(new Color(0,255,0));
                                
                            } 
                            else if (btn.getModel().isRollover()) {
                                btn.setOpaque(true);
                                btn.setBackground(new Color(152,251,152));
                            } 
                            else {
                                btn.setBackground(new Color(50,205,50));
                            }
                        }
                    });
                    go.addChangeListener(new ChangeListener() {
                        public void stateChanged(ChangeEvent e){
                            JButton btn = go;
                            if (btn.getModel().isPressed()) {
                                btn.setOpaque(true);
                                btn.setBackground(new Color(0,191,255));
                                
                            } 
                            else if (btn.getModel().isRollover()) {
                                btn.setOpaque(true);
                                btn.setBackground(new Color(30,144,255));
                            } 
                            else {
                                RoundBtn.desginButton(btn, 10);
                                btn.setOpaque(true);
                                btn.setBackground(new Color(70,130,180));
                            }
                        }
                    });

                    // Search bar
                    JTextField search_bar = new JTextField("Search by ID");
                    RoundBtn.desginButton(search_bar);
                    search_bar.setOpaque(true);
                    search_bar.setBounds(200, 200, 190, 50);

                    search.addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                // Go for new data
                                try {
                                    int id = Integer.parseInt(search_bar.getText());
                                    boolean id_found = false;
                                    for (Student student : students) {
                                        if(student.getId() == id){
                                            model.getDataVector().removeAllElements();
                                            table.repaint();
                                            addToModel(student, model);
                                            id_found = true;
                                            break;
                                        }
                                    }
                                    if(!id_found){
                                        JOptionPane.showMessageDialog(newWindow, "ID is not exist !");
                                    }
                                } catch (Exception e2) {
                                    JOptionPane.showMessageDialog(newWindow, "Please search only by ID!");
                                }
                                table.getSelectionModel().clearSelection();
                            }
                        }
                    );

                    go.addActionListener(
                         new ActionListener(){
                            int selectedStage;
                             public void actionPerformed(ActionEvent e){
                                // Go for new data
                                selectedStage = stage_box.getSelectedIndex() + 1;
                                
                                model.getDataVector().removeAllElements();
                                table.repaint();
                                if(selectedStage == 5){
                                    for (Student student : students) {
                                        addToModel(student, model);
                                    }
                                }else
                                {
                                    for (Student student : students)
                                    {
                                        if(student.getStage() ==  selectedStage)
                                        {
                                            addToModel(student, model);
                                        }
                                    }
                                }
                                table.getSelectionModel().clearSelection();
                             }
                         }
                     );

                    // Course button
                    JButton course_button = new JButton("Course");
                    RoundBtn.desginButton(course_button, 10);
                    course_button.setOpaque(true);
                    course_button.setBackground(new Color(255,140,0));
                    course_button.setBounds(700,410, 100,50);
                    course_button.setVisible(false);
                    

                    // Save button
                    JButton save = new JButton("Save");
                    RoundBtn.desginButton(save, 10);
                    save.setOpaque(true);
                    save.setBackground(new Color(70,130,180));
                    save.setBounds(700,530, 100,50);
                    save.setVisible(false);
                    
                    // Delete button
                    JButton delete = new JButton("Delete");
                    RoundBtn.desginButton(delete, 10);
                    delete.setOpaque(true);
                    delete.setBackground(new Color(217, 83, 79));
                    delete.setBounds(700,470, 100,50);


                    course_button.addChangeListener(
                        new ChangeListener() {
                            @Override
                            public void stateChanged(ChangeEvent e) {
                                JButton btn = course_button;
                                if (btn.getModel().isPressed()) {
                                    btn.setOpaque(true);
                                    btn.setBackground(new Color(255,127,80));
                                    
                                } 
                                else if (btn.getModel().isRollover()) {
                                    btn.setOpaque(true);
                                    btn.setBackground(new Color(255,215,0));
                                } 
                                else {
                                    RoundBtn.desginButton(btn, 10);
                                    btn.setOpaque(true);
                                    btn.setBackground(new Color(255,140,0));
                                }
                            }
                        }
                    );
                    delete.addChangeListener(
                        new ChangeListener() {
                            @Override
                            public void stateChanged(ChangeEvent e) {
                                JButton btn = delete;
                                if (btn.getModel().isPressed()) {
                                    btn.setOpaque(true);
                                    btn.setBackground(new Color(255,105,180));
                                } 
                                else if (btn.getModel().isRollover()) {
                                    btn.setOpaque(true);
                                    btn.setBackground(new Color(255,20,147));
                                } 
                                else {
                                    btn.setBackground(new Color(217, 83, 79));
                                }
                            }
                        }
                    );
                    save.addChangeListener(new ChangeListener() {
                        public void stateChanged(ChangeEvent e){
                            JButton btn = save;
                            if (btn.getModel().isPressed()) {
                                btn.setOpaque(true);
                                btn.setBackground(new Color(0,191,255));
                                
                            } 
                            else if (btn.getModel().isRollover()) {
                                btn.setOpaque(true);
                                btn.setBackground(new Color(30,144,255));
                            } 
                            else {
                                RoundBtn.desginButton(btn, 10);
                                btn.setOpaque(true);
                                btn.setBackground(new Color(70,130,180));
                            }
                        }
                    });

                    delete.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            try {
                                int selected_item = table.getSelectedRow();
                                Object selected_id = table.getModel().getValueAt(selected_item, 0);
                                int id = Integer.parseInt(selected_id.toString());

                                if(JOptionPane.showConfirmDialog(newWindow, "Do u want to delete ", "Delete!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                                    for (Student st: students) {
                                        if(st.getId() == id){
                                            students.remove(st);
                                            break;
                                        }
                                    }
                                    Student.updateData(file, students);
                                    Course.updateData(course_file, students);
                                    save.setVisible(false);
                                    course_button.setVisible(false);
                                    model.removeRow(selected_item);
                                    
                                }
                            } 
                            catch (Exception e2) {
                            }
                           
                        }
                    });

                    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent event) 
                        {
                            if (!event.getValueIsAdjusting()) {
                                if (table.getSelectedRow() > -1) {
                                    save.setVisible(true);
                                    course_button.setVisible(true);
                                }
                            }
                        }
                    });
                    
                    save.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            // Save progress
                            Object infos = new Object();
                            for (int i = 0; i < model.getRowCount(); i++) 
                            {
                                for (int j = 0; j < model.getColumnCount(); j++)
                                {
                                    infos = model.getValueAt(i, j);
                                    if(j == 0)
                                    {
                                        int id =Integer.parseInt(infos.toString()); 
                                        students.get(i).setId(id);
                                    }else if(j == 1){
                                        students.get(i).setFullname(infos.toString());
                                    }else if(j == 2){
                                        students.get(i).setAddress(infos.toString());
                                    }else if(j == 3){
                                        students.get(i).setMobile(infos.toString());
                                    }else if(j == 4){
                                        students.get(i).setStage(Integer.parseInt(infos.toString()));
                                    }
                                }
                                Student.updateData(file, students);
                            }
                            save.setVisible(false);
                            course_button.setVisible(false);
                            table.getSelectionModel().clearSelection();
                            JOptionPane.showMessageDialog(newWindow , "Saved successfuly!");
                            return;
                        }
                    });
                    course_button.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            int selected_item = table.getSelectedRow();
                            Object selected_id = table.getModel().getValueAt(selected_item, 0);
                            int id = Integer.parseInt(selected_id.toString());
                            String course_data = "<html><h1>Courses !</h1>";
                            int j = 0;
                            for (Student st: students) 
                            {
                                if(st.getId() == id)
                                {
                                    for (String course : st.getCourses()) 
                                    {
                                        if(!course.equals("none"))
                                        {
                                            course_data += "<h4>";
                                            course_data += course;
                                            course_data += "</h4>";
                                            j++;
                                        }
                                    }
                                }
                                
                            }
                            course_data += "</html>";
                            if(j!=0){
                                JOptionPane.showMessageDialog(newWindow, course_data);
                            }else{
                                JOptionPane.showMessageDialog(newWindow, "Didn't joined any course!");
                            }
                            table.getSelectionModel().clearSelection();
                            save.setVisible(false);
                            course_button.setVisible(false);
                            j=0;
                        }
                    });

                    
        
                    
                    newWindow.add(stage);
                    newWindow.add(stage_box);
                    newWindow.add(Tpanel);
                    newWindow.add(course_button);
                    newWindow.add(delete);
                    newWindow.add(save);
                    newWindow.add(go);
                    newWindow.add(search);
                    newWindow.add(search_bar);
                    
                    newWindow.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            model.getDataVector().removeAllElements();
                            
                        }
                    });
                    table.clearSelection();
                    newWindow.setVisible(true);
                }
            }
        );
        

        panel1.add(title);
        panel1.add(studentsDataButton);
        panel1.add(registerButton);
        
        window.setLocationRelativeTo(null);
        window.add(panel1);

        window.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == registerButton){
            if (registerButton.getModel().isPressed()) {
                registerButton.setOpaque(true);
                registerButton.setBackground(Color.BLACK);
            } 
            else if (registerButton.getModel().isRollover()) {
                registerButton.setOpaque(true);
                registerButton.setForeground(Color.WHITE);
                registerButton.setBackground(new Color(54, 69, 79));
            } 
            else {
                RoundBtn.desginButton(registerButton, 10);
            }
        }
        if(e.getSource() == studentsDataButton){
            if (studentsDataButton.getModel().isPressed()) {
                studentsDataButton.setOpaque(true);
                studentsDataButton.setBackground(new Color(240, 173, 78));
            } 
            else if (studentsDataButton.getModel().isRollover()) {
                studentsDataButton.setOpaque(true);
                studentsDataButton.setBackground(new Color(255, 195, 0));
            } 
            else {
                RoundBtn.desginButton(studentsDataButton, 10);
            }
        }
    }
}


class RoundBtn implements Border
{
    private int r;
    RoundBtn(int r) {
        this.r = r;
    }
    public static void desginButton(JButton btn, int radius)
    {
        btn.setFont(new Font("Verdana", Font.BOLD, 13));
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setOpaque(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBorder(new RoundBtn(radius));
    }

    public static void desginButton(JLabel lbl)
    {
        lbl.setForeground(Color.BLACK);
        lbl.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20));
    }

    public static void desginButton(JTextField txtFld)
    {
        txtFld.setBackground(Color.WHITE);
        txtFld.setForeground(Color.BLACK);
        txtFld.setOpaque(true);
        txtFld.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 17));
        txtFld.setBorder(new RoundBtn(10));
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