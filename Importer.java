import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Importer 
{
    public static void importData(String file, String data)
    {
        FileWriter Writer = null;
        try {
            Writer = new FileWriter(file, true);
            Writer.append(data);
            Writer.append("\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try {
                Writer.flush();
                Writer.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void clearFile(String file){
    FileWriter Writer = null;
        try {
            Writer = new FileWriter(file, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try {
                Writer.flush();
                Writer.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static String read(String file){
        String data = "";
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int i;
            while((i = reader.read()) != -1){
                data += (char)i;
            }
            return data;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static void updateData(String file, ArrayList<Student> students){
        clearFile(file);
        for (Student student : students) {
            importData(file, student.toString());

        }
    }

    public static void loadData(String file, ArrayList<Student> students)
    {
        try {
            String student_data = read(file);
            String []student_data_array = student_data.split("[, \n]");
            int j = 0;
            for (int i = 0; i < student_data_array.length/5; i++) 
            {
                Student student = new Student();
                student.setId(Integer.parseInt(student_data_array[j++]));
                student.setFullname(student_data_array[j++]);
                student.setAddress(student_data_array[j++]);
                student.setMobile(student_data_array[j++]);
                student.setStage(Integer.parseInt(student_data_array[j++]));
                j++;
                students.add(student);
            }

        } catch (Exception e) {

        }
    }

}
