import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

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
        try {
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

}
